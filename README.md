DogeCoin-JRPC
=============

A java api that wraps the dogecoind JSON-RPC api.  ![Build Status](https://travis-ci.org/sinemetu1/DogeCoin-JRPC.png)

[What's dogecoin?](http://dogecoin.com/)

![](http://i.imgur.com/KGE6WIc.png)

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
    
### Improvements:

- Add maven central repo support (in progress)
- More tests

Feel free to create issues for feature requests or if you have any issues with the project.

Donations appreciated at: `DEag5bzJ6pEKymjLhXzHeQhfNo3XBSNrHg`
