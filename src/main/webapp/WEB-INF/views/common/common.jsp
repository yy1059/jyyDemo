<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script src="http://static.gdcccn.com/vue@2.6.10/dist/vue.js"></script>
<script src="http://static.gdcccn.com/element-ui@2.11.1/lib/index.js"></script>
<script type="text/javascript" src="/static/js/common/axios.min.js"></script>
<link rel="stylesheet" href="http://static.gdcccn.com/element-ui@2.11.1/lib/theme-chalk/index.css">
<link rel="stylesheet" href="/static/css/sys/common.css">
<script type="text/javascript" src="/static/js/common/axios.common.js"></script>
<script>
    var context="${pageContext.request.contextPath}";
    var CURRENT_USER_ID = 'CURRENT_USER_ID';    // 当前登录用户
    //checkLogin();
    //setDateFormatFun();

    function changHeight() {
        if (document.body.clientHeight > 768 && document.body.clientHeight < 1080) {

            document.getElementById("myMenu").style.maxHeight = document.body.clientHeight - 80;
            document.getElementById("myMain").style.maxHeight = document.body.clientHeight - 80;
            document.getElementById("iframe-page").style.maxHeight = document.body.clientHeight - 80;
        }

        if (document.body.clientHeight < 768&&document.body.clientHeight>607) {
            document.getElementById("myMenu").style.minHeight = document.body.clientHeight - 80;
            document.getElementById("myMain").style.minHeight = document.body.clientHeight - 80;
            document.getElementById("iframe-page").style.maxHeight = document.body.clientHeight - 80;
        }

        if (document.body.clientHeight<607){
            document.getElementById("myMenu").style.minHeight = 527;
            document.getElementById("myMain").style.minHeight = 527;
            document.getElementById("iframe-page").style.maxHeight = 527;
        }
    }

   /* function checkLogin() {
        if (!getQueryVariable("userId")){
            var data = {
                method: 'get',
                url: context + '/user/check/login'
            };
            axios(data).then(function (result) {
                var data = result.data;
                if (data.status === 1) {
                } else {
                    window.parent.location.href=context+'/view/login/login.htm';
                }
            });
        }
    }*/
    function getQueryVariable(variable)         // 获取url参数
    {
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i = 0;i < vars.length; i++) {
            var pair = vars[i].split("=");
            if(pair[0] === variable){return pair[1];}
        }
        return false;
    }

    function validValue(val) {
        return val === '' ? null : val;
    }

    function setDateFormatFun() {
        Date.prototype.format = function(fmt) {
            var o = {
                "M+" : this.getMonth()+1,                 //月份
                "d+" : this.getDate(),                    //日
                "h+" : this.getHours(),                   //小时
                "m+" : this.getMinutes(),                 //分
                "s+" : this.getSeconds(),                 //秒
                "q+" : Math.floor((this.getMonth()+3)/3), //季度
                "S"  : this.getMilliseconds()             //毫秒
            };
            if(/(y+)/.test(fmt)) {
                fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
            }
            for(var k in o) {
                if(new RegExp("("+ k +")").test(fmt)){
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
                }
            }
            return fmt;
        };
    }
</script>
