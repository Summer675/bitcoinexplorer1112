var app = new Vue({
    el: '#app',
    data: {
        TransactionUnconfirmed:[],
        
    },
    methods:{
        bitcoinPushConnect() {
            console.log('连接中');

            this.socket = new SockJS('http://localhost:8080/bitcoinexplorerpush');
            this.stompclient = Stomp.over(this.socket);
            this.stompclient.connect({}, frame => {
                console.log(frame);
                this.stompclient.subscribe('/bitcoin/deltaTx', function (data) {
                    console.log(data)
                   var newTransactions= JSON.parse(data.body);
                    app.TransactionUnconfirmed=newTransactions.concat(app.TransactionUnconfirmed);
                    //[..newT。。，..Tr。。。]
                });
            });

        },
        handleConnect() {
            console.log('连接到客户端');
            this.bitcoinPushConnect();
        }
    }
})