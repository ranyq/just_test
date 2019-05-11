addToCart=function(bookId,bookName){
    $.ajax({
        type:'post',
        dataType:'json',
        contentType: 'application/json; charset=UTF-8',
        url:'/collection/add',
        data:JSON.stringify({bookId:bookId,bookName:bookName}),
        success:function(){
            alert("已添加入购物车")

        },
        error:function(){
            alert("未知原因添加购物车失败，请稍后重试");
        }
    })
}
