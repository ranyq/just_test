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
}