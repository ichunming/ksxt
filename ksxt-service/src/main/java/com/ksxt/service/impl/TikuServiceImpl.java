/**
 * @author ming
 * @date 2017年2月9日 下午4:45:14
 */
package com.ksxt.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.ksxt.common.constant.ErrorCode;
import com.ksxt.common.constant.KechengStatus;
import com.ksxt.common.constant.SystemSettings;
import com.ksxt.common.constant.TikuStatus;
import com.ksxt.common.helper.ExcelException;
import com.ksxt.common.util.DateUtil;
import com.ksxt.common.util.ExcelUtil;
import com.ksxt.common.util.StringUtil;
import com.ksxt.dao.AnlifenxiDao;
import com.ksxt.dao.AnlifenxiSubDao;
import com.ksxt.dao.DanxuanDao;
import com.ksxt.dao.DuoxuanDao;
import com.ksxt.dao.JisuanfenxiDao;
import com.ksxt.dao.JisuanfenxiSubDao;
import com.ksxt.dao.KcTxRelDao;
import com.ksxt.dao.KechengDao;
import com.ksxt.dao.PanduanDao;
import com.ksxt.dao.TikuDao;
import com.ksxt.dao.TixingDao;
import com.ksxt.model.Anlifenxi;
import com.ksxt.model.AnlifenxiSub;
import com.ksxt.model.Danxuan;
import com.ksxt.model.Duoxuan;
import com.ksxt.model.Jisuanfenxi;
import com.ksxt.model.JisuanfenxiSub;
import com.ksxt.model.KcTxRel;
import com.ksxt.model.Kecheng;
import com.ksxt.model.Panduan;
import com.ksxt.model.Tiku;
import com.ksxt.service.ITikuService;
import com.ksxt.vo.AnlifenxiVo;
import com.ksxt.vo.BaseResult;
import com.ksxt.vo.JisuanfenxiVo;
import com.ksxt.vo.KsxtPageInfo;
import com.ksxt.vo.PanduanVo;
import com.ksxt.vo.TikuParam;
import com.ksxt.vo.TikuVo;
import com.ksxt.vo.XuanzeVo;

@Service
public class TikuServiceImpl implements ITikuService {
	private static final Logger logger = LoggerFactory.getLogger(TikuServiceImpl.class);
	
	@Autowired
	private KechengDao kechengDao;
	
	@Autowired
	private TikuDao tikuDao;
	
	@Autowired
	private TixingDao tixingDao;
	
	@Autowired
	private DanxuanDao danxuanDao;
	
	@Autowired
	private DuoxuanDao duoxuanDao;
	
	@Autowired
	private PanduanDao panduanDao;
	
	@Autowired
	private AnlifenxiDao anlifenxiDao;
	
	@Autowired
	private AnlifenxiSubDao anlifenxiSubDao;
	
	@Autowired
	private JisuanfenxiDao jisuanfenxiDao;
	
	@Autowired
	private JisuanfenxiSubDao jisuanfenxiSubDao;
	
	@Autowired
	private KcTxRelDao kcTxRelDao;
	
	/* (non-Javadoc)
	 * @see com.ksxt.service.IShitiService#check(java.lang.String, java.lang.Integer, org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public BaseResult check(String name, Integer kcId, MultipartFile file) {
		// check empty
		if(StringUtil.isEmpty(name) || null == kcId || null == file || file.isEmpty()) {
			// missing parameter
			logger.debug("missing parameter.");
			return new BaseResult(ErrorCode.ERR_SYS_REQUEST_MISSING_PARAMETER);
		}
		
		// check kcId
		Kecheng kecheng = kechengDao.select(kcId);
		if(null == kecheng) {
			logger.debug("invalid kcId.");
			return new BaseResult(ErrorCode.ERR_SYS_REQUEST_INVALID_PARAMETER);
		}

		// check kecheng status
		if(kecheng.getStatus() == KechengStatus.INVALID.getCode()) {
			logger.debug("kecheng invalid.");
			return new BaseResult(ErrorCode.ERR_MGR_KC_INVALID);
		}
		
		// check kecheng template
		List<KcTxRel> kcTxRels = kcTxRelDao.getByKcId(kcId);
		if(kcTxRels.size() == 0) {
			logger.debug("kecheng no template.");
			return new BaseResult(ErrorCode.ERR_MGR_KC_NO_TPL);
		}
		
		return new BaseResult(ErrorCode.SUCCESS);
	}

	/* (non-Javadoc)
	 * @see com.ksxt.service.ITikuService#save(java.lang.String, java.lang.String, java.lang.Integer, org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public BaseResult save(String tempDir, String name, Integer kcId, MultipartFile file) throws Exception{

		long fileId = System.currentTimeMillis();
		String destFile = tempDir + fileId;
		OutputStream fileStream = null;
		try {
			// save file to server
			logger.debug("save file to server...");
			fileStream = new FileOutputStream(new File(destFile));
			FileCopyUtils.copy(file.getInputStream(), fileStream);
			
			// save file information to database
			logger.debug("save file information to database...");
			Date current = DateUtil.current();
			Integer nextTkId = tikuDao.getCurMaxId() + 1;
			
			// import to DB
			logger.debug("import to database...");
			import2DB(kcId, nextTkId, destFile);
			
			// save file information to database
			logger.debug("save file information to database...");
			Tiku tiku = new Tiku();
			tiku.setId(nextTkId);
			tiku.setCreateDate(current);
			tiku.setKcId(kcId);
			tiku.setName(name);
			tiku.setPath(destFile);
			tiku.setStatus(TikuStatus.UNDISTR.getCode());
			tiku.setUpdateDate(current);
			tikuDao.insert(tiku);
			
		} finally {
			if(null != fileStream) {
				try {
					fileStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			File tmpFile = new File(destFile);
			if(tmpFile.exists()) {
				tmpFile.delete();
			}
		}
		
		return new BaseResult(ErrorCode.SUCCESS);
	}

	/* (non-Javadoc)
	 * @see com.ksxt.service.ITikuService#list(com.ksxt.vo.TikuParam, java.lang.Integer)
	 */
	@Override
	public BaseResult list(TikuParam param, Integer page) {
		// set page
		logger.debug("set page...");
		PageHelper.startPage(page, SystemSettings.PAGE_SIZE);
		
		// get list
		logger.debug("get list...");
		List<TikuVo> tikuList = tikuDao.getList(param);
		
		return new BaseResult(ErrorCode.SUCCESS, new KsxtPageInfo<TikuVo>(tikuList));
	}

	/* (non-Javadoc)
	 * @see com.ksxt.service.ITikuService#delete(java.lang.Integer)
	 */
	@Override
	public BaseResult delete(Integer tikuId) {
		// check parameter
		logger.debug("check parameter...");
		if(null == tikuId) {
			logger.debug("missing request parameter.");
			return new BaseResult(ErrorCode.ERR_SYS_REQUEST_MISSING_PARAMETER);
		}
		
		// delete
		logger.debug("delete tiku[" + tikuId + "]...");
		tikuDao.delete(tikuId);
		return new BaseResult(ErrorCode.SUCCESS);
	}

	private void import2DB(Integer kcId, Integer tkId, String path) throws IOException {
		// get kecheng-Tixing Relationship
		logger.debug("get kecheng-Tixing Relationship...");
		List<KcTxRel> kcTxRels = kcTxRelDao.getByKcId(kcId);
    	
    	InputStream is = null;
    	POIFSFileSystem fs = null; // file
    	HSSFWorkbook wb = null; // workbook
		
		try {
			// load file
			is = new FileInputStream(path);
			fs = new POIFSFileSystem(is);
			// create excel workbook
	        wb = new HSSFWorkbook(fs);

	        // read to database
	        for(int index = 0; index < kcTxRels.size(); index++) {
	        	read2DB(wb, index, kcTxRels.get(index).getTxId(), tkId);
	    	}
		} finally {
			if(null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void read2DB(HSSFWorkbook wb, int index, Integer txId, int tkId) throws ExcelException {
        // get sheet
        Sheet sheet = wb.getSheetAt(index);
        int lastRowNum = sheet.getLastRowNum();
        // count total page
        int totalPage = (int)Math.ceil((double)(lastRowNum) / SystemSettings.BATCH_SIZE);
        Date current = DateUtil.current();
    	int order = 0;
        // set ExcelUtil target
        ExcelUtil.setTarget(wb, sheet);
        
        switch (txId) {
		case 1:
			// danxuan
        	logger.debug("read danxuan to database, totalPage[" + totalPage + "]...");
        	List<XuanzeVo> danxuanVos = null;
        	List<Danxuan> danxuans = null;
        	for(int curPage = 0; curPage < totalPage; curPage++) {
        		logger.debug("currentPage[" + curPage + "]");
        		danxuanVos = ExcelUtil.convertToList(XuanzeVo.class, curPage * SystemSettings.BATCH_SIZE + 1, SystemSettings.BATCH_SIZE);
        		danxuans = covertToDanxuan(danxuanVos, tkId);
        		// batch insert
        		logger.debug("batch insert...");
        		danxuanDao.batchInsert(danxuans);
        		
        		// clear
        		danxuanVos.clear();
        		danxuans.clear();
        	}
        	logger.debug("read danxuan to database successfully.");
			break;
		case 2:
			// duoxuan
        	logger.debug("read duoxuan to database, totalPage[" + totalPage + "]...");
        	List<XuanzeVo> duoxuanVos = null;
        	List<Duoxuan> duoxuans = null;
        	for(int curPage = 0; curPage < totalPage; curPage++) {
        		logger.debug("currentPage[" + curPage + "]");
        		duoxuanVos = ExcelUtil.convertToList(XuanzeVo.class, curPage * SystemSettings.BATCH_SIZE + 1, SystemSettings.BATCH_SIZE);
        		duoxuans = covertToDuoxuan(duoxuanVos, tkId);
        		// batch insert
        		logger.debug("batch insert...");
        		duoxuanDao.batchInsert(duoxuans);
        		
        		// clear
        		duoxuanVos.clear();
        		duoxuans.clear();
        	}
        	logger.debug("read duoxuan to database successfully.");
			break;
		case 3:
			// panduan
        	logger.debug("read panduan to database, totalPage[" + totalPage + "]...");
        	List<PanduanVo> panduanVos = null;
        	List<Panduan> panduans= null;
        	for(int curPage = 0; curPage < totalPage; curPage++) {
        		logger.debug("currentPage[" + curPage + "]");
        		panduanVos = ExcelUtil.convertToList(PanduanVo.class, curPage * SystemSettings.BATCH_SIZE + 1, SystemSettings.BATCH_SIZE);
        		panduans = covertToPanduan(panduanVos, tkId);
        		// batch insert
        		logger.debug("batch insert...");
        		panduanDao.batchInsert(panduans);
        		
        		// clear
        		panduanVos.clear();
        		panduans.clear();
        	}
        	logger.debug("read panduan to database successfully.");
			break;
		case 4:
			// jisuanfenxi
        	logger.debug("read jisuanfenxi to database...");
        	// process each record
        	JisuanfenxiVo jisuanfenxiVo = null;
        	Jisuanfenxi jisuanfenxi = null;
        	JisuanfenxiSub jisuanfenxiSub = null;
        	
        	for(int curRowNum = 1; curRowNum <= lastRowNum; curRowNum++) {
        		jisuanfenxiVo = ExcelUtil.convertToObj(JisuanfenxiVo.class, curRowNum);
        		
        		if(isSub(jisuanfenxiVo.getNo())) {
        			// jisuanfenxi sub
        			jisuanfenxiSub = jisuanfenxiVo.toJisuanfenxiSub();
        			jisuanfenxiSub.setJsfxId(jisuanfenxi.getId());
        			jisuanfenxiSub.setCreateDate(current);
        			jisuanfenxiSub.setUpdateDate(current);
        			jisuanfenxiSub.setOrderId(order++);
        			
        			jisuanfenxiSubDao.insert(jisuanfenxiSub);
        		} else {
        			// jisuanfenxi
        			jisuanfenxi = jisuanfenxiVo.toJisuanfenxi();
        			jisuanfenxi.setCreateDate(current);
        			jisuanfenxi.setTkId(tkId);
        			jisuanfenxi.setUpdateDate(current);
        			
        			jisuanfenxiDao.insertUseGenKey(jisuanfenxi);
        			order = 1;
        		}
        	}
        	logger.debug("read jisuanfenxi to database successfully.");
			break;
		case 5:
			// anlifenxi
        	logger.debug("read anlifenxi to database...");
        	// process each record
        	AnlifenxiVo anlifenxiVo = null;
        	Anlifenxi anlifenxi = null;
        	AnlifenxiSub anlifenxiSub = null;
        	
        	for(int curRowNum = 1; curRowNum <= lastRowNum; curRowNum++) {
        		anlifenxiVo = ExcelUtil.convertToObj(AnlifenxiVo.class, curRowNum);
        		
        		if(isSub(anlifenxiVo.getNo())) {
        			// anlifenxi sub
        			anlifenxiSub = anlifenxiVo.toAnlifenxiSub();
        			anlifenxiSub.setAlfxId(anlifenxi.getId());
        			anlifenxiSub.setCreateDate(current);
        			anlifenxiSub.setUpdateDate(current);
        			anlifenxiSub.setOrderId(order++);
        			
        			anlifenxiSubDao.insert(anlifenxiSub);
        		} else {
        			// anlifenxi
        			anlifenxi = anlifenxiVo.toAnlifenxi();
        			anlifenxi.setCreateDate(current);
        			anlifenxi.setTkId(tkId);
        			anlifenxi.setUpdateDate(current);
        			
        			anlifenxiDao.insertUseGenKey(anlifenxi);
        			order = 1;
        		}
        	}
        	logger.debug("read anlifenxi to database successfully.");
			break;
		default:
			break;
		}
	}
	
	private boolean isSub(String no) {
		return StringUtil.isEmpty(no);
	}
	
	private List<Danxuan> covertToDanxuan(List<XuanzeVo> xuanzeVos, Integer tkId) {
		List<Danxuan> danxuans = new ArrayList<Danxuan>(xuanzeVos.size());
		Danxuan danxuan = null;
		Date current = DateUtil.current();
		
		for(XuanzeVo xuanzeVo : xuanzeVos) {
			danxuan = xuanzeVo.toDanxuan();
			danxuan.setCreateDate(current);
			danxuan.setUpdateDate(current);
			danxuan.setTkId(tkId);
			danxuans.add(danxuan);
		}
		
		return danxuans;
	}
	
	private List<Duoxuan> covertToDuoxuan(List<XuanzeVo> xuanzeVos, Integer tkId) {
		List<Duoxuan> duoxuans = new ArrayList<Duoxuan>(xuanzeVos.size());
		Duoxuan duoxuan = null;
		Date current = DateUtil.current();
		
		for(XuanzeVo xuanzeVo : xuanzeVos) {
			duoxuan = xuanzeVo.toDuoxuan();
			duoxuan.setCreateDate(current);
			duoxuan.setUpdateDate(current);
			duoxuan.setTkId(tkId);
			duoxuans.add(duoxuan);
		}
		
		return duoxuans;
	}
	
	
	private List<Panduan> covertToPanduan(List<PanduanVo> panduanVos, Integer tkId) {
		List<Panduan> panduans = new ArrayList<Panduan>(panduanVos.size());
		Panduan panduan = null;
		Date current = DateUtil.current();
		
		for(PanduanVo panduanVo : panduanVos) {
			panduan = panduanVo.toPanduan();
			panduan.setCreateDate(current);
			panduan.setUpdateDate(current);
			panduan.setTkId(tkId);
			panduans.add(panduan);
		}
		
		return panduans;
	}
}