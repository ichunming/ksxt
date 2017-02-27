// API URL
/*var API_CHECK_USERNAME = "http://localhost:8082/api/user/check/username";
var API_CHECK_MOBILE = "http://localhost:8082/api/user/check/mobile";
*/
// apiCheck--调用API, 有错误显示错误信息
var apiCheck = function(url, data) {
	$.ajax({
	    url:url,
	    type:'POST', //GET
	    data:data,
	    success:function(data){
	    	var result = eval(data);
	    	
	    	if(result.code != 0) {
	    		$(".divMsg span").text(result.data.content);
	    	} else {
	    		$(".divMsg span").text("");
	    	}
	    },
	    error:function(xhr){
	        console.log("api error");
	    }
	})	
};

// check username
var checkUsername = function() {
    var username = $("#userName").val();
    
    if(username.trim().length < 1 || username.trim().length > 12) {
        $(".divMsg span").text("用户名长度1到12个字符");
        return false;
    }
    
    return true;
};

// check password
var checkPwd = function() {
    var password = $("#password").val();
    
    if(password.trim().length < 6 || password.trim().length > 12) {
        $(".divMsg span").text("密码为6到12位数字和字母组合");
        return false;
    }
    
    return true;
};

// check mobile
var checkMobile = function() {
    var mobile = $("#mobile").val();
    
    if(mobile.trim().length != 11) {
        $(".divMsg span").text("手机号码格式不正确");
        return false;
    }
    
    return true;
};