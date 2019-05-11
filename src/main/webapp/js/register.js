function checkInfo(){
    var username=document.getElementById("name").value;
    var password=document.getElementById("password").value;
    var password2=document.getElementById("password2").value;
    if(username==null||username==""){
        alert("用户名不能为空！");
        return false;
    }
    if(password==null||password==""){
        alert("密码不能为空！");
        return false;
    }
    if(password!=password2){
        alert("两次密码不一致，请检查后重新输入！")
        return false;
    }

}

function checkUserName(){
    var name=document.getElementById("name").value;
    $.ajax({
        type:'post',
        dataType:'json',
        contentType: 'application/json; charset=UTF-8',
        url:'/user/checkusername',
        data:JSON.stringify({name:name}),
        success:function(data){
            var result=JSON.parse(data);
            if(result>0){
                document.getElementById("submit").setAttribute("disabled","true");
                document.getElementById("checkresult").innerHTML="用户名重复，请重新输入！";

            }else{
                document.getElementById("submit").removeAttribute("disabled");
                document.getElementById("checkresult").innerHTML="";
            }
        },
        error:function(){
        }
    })
}