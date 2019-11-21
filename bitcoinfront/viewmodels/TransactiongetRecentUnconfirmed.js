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
                });
            });

        },
        handleConnect() {
            console.log('连接到客户端');
            this.bitcoinPushConnect();
        }
    }
})