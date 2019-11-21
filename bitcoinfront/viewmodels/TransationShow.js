var app = new Vue({
    el: '#app',
    data: {
       txid: '',
        transaction: ''
    },
    methods: {
        getTxByTxid() {
            axios.get('/transaction/getTransactionByTxid', {
                params: {
                    txid: this.txid
                }
            })
                .then(res=>{
                    console.log(res);
                    app.transaction = res.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    },
    mounted(){
        console.log('view mounted');

        var url = new URL(location.href);
        this.txid = url.searchParams.get("txid");
        if (!this.txid) {
            alert('txid null');
            return;
        }

        this.getTxByTxid();
        
    }
})