var app = new Vue({
    el: '#app',
    data: {
        keyword:'',

    },
    motheds:{
        ss(){
            console.log("搜索页面")
            if(!isNaN(this.keyword)){//如果不是字符串  那么就是数字
                console.log("this is shuzi");
                this.getBlockhashByHeight();
                return ;
            }

            if(this.keyword.length<64){//转往地址
                console.log("go to Address Info");
                location.href="Addressinfo?address="+this.keyword;
                return ;
            }

            if(this.keyword.startsWith('00000')){
                console.log("go to blockshow");  
                location.href = 'BlockShow?blockhash=' + this.keyword;
                return ;       
            }else{
                console.log("go to tx show page");
                location.href = 'Transactionshow?txid=' + this.keyword;
                return ;
            }
        },
        getBlockhashByHeight() {
            axios.get('/block/getBlockhashByHeight', {
                params: {
                    height: this.keyword
                }
            })
                .then(res=>{
                    console.log(res);
                    app.keyword = res.data;
                    location.href = 'BlockShow?blockhash=' + app.keyword;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    
    }
})