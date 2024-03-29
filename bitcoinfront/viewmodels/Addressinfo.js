var app = new Vue({
    el: '#app',
    data: {
        address: '',
        addressinfo: '',
        page: 1,
        txPageinfo: '',
        visible: false,
        
    },

    methods: {
        getAddressInfoByAddress() {
            axios.get('/address/getInfoByAddress', {
                params: {
                    address: this.address
                }
            })
                .then(res => {
                    console.log(res);
                    app.addressinfo = res.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        getTransactionsByAddress() {
            axios.get('/transaction/getTransactionByAddressWithPage', {
                params: {
                    address: this.address,
                    page: this.page
                }
            })
                .then(res=> {
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
        this.address = url.searchParams.get("address");
        if (!this.address) {
            alert('address null');
            return;
        }

        var qrcode = new QRCode("AddressQRCode", {
            text: this.address,
            width: 128,
            height: 128,
            colorDark: "#000000",
            colorLight: "#ffffff",
            correctLevel: QRCode.CorrectLevel.H
        });
       this.getAddressInfoByAddress();
       this.getTransactionsByAddress();
    },
})