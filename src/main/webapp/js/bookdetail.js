addToCart=function(bookId,bookName){
    $.ajax({
        type:'post',
        dataType:'json',
        contentType: 'application/json; charset=UTF-8',
        url:'/collection/add',
        data:JSON.stringify({bookId:bookId,bookName:bookName}),
        success:function(){
            alert("ok")

        },
        error:function(){
            alert(url);
        }
    })
}
