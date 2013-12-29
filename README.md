DogeCoin-JRPC
=============

A java rpc api that wraps dogecoind.

### Requirements:

`dogecoind` [for linux](https://github.com/dogecoin/dogecoin#wow-plz-make-dogecoind) or [for OSX](https://github.com/sinemetu1/dogecoin#mac-osx)

### Configuration:

Set environment variables used to access the `dogecoind` instance:

    export DOGE_COIN_RPC_USERNAME=dogecoinrpc
    export DOGE_COIN_RPC_PASSWORD=YOUR_PASSWORD

### Build the api:

    git clone https://github.com/sinemetu1/DogeCoin-JRPC.git
    cd DogeCoin-JRPC/
    mvn clean install

### Test:

    cd DogeCoin-JRPC/
    mvn clean test
