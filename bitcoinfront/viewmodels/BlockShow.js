var app = new Vue({
    el: '#app',
    data: {

        blockhash: '',
        block: '',
        page: 1,
        txPageinfo: '',
        visible: false,
    },
    methods: {
        getBlockByBlockhash() {
            axios.get('/block/getInfoByHash', {
                params: {
                    blockhash: this.blockhash
                }
            })
                .then(res => {
                    console.log(res);
                    app.block = res.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        getTransactionsByBlockhash() {
            axios.get('/transaction/getTransactionByAddressWithPage', {
                params: {
                    blockhash: this.blockhash,
                    page: this.page
                }
            })
                .then(res => {
                    console.log(res);
                    app.txPageinfo = res.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
      
    },
    mounted() {

        var url = new URL(location.href);
        this.blockhash = url.searchParams.get("blockhash");
        if (!this.blockhash) {
            alert('blockhash null');
            return;
        }

        this.getBlockByBlockhash();
        this.getTransactionsByBlockhash();

    }
})