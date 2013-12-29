package com.dogecoin.api;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class Wallet {
	
	private String username;
	private String password;
	
	private static final String METHOD = "method";
	private static final String PARAMS = "params";
	
	public Wallet() {
		username = System.getenv("DOGE_COIN_RPC_USERNAME");
		password = System.getenv("DOGE_COIN_RPC_PASSWORD");
	}

	public Wallet(String _username, String _password) {
		username = _username;
		password = _password;
	}

    //addmultisigaddress <nrequired> <'["key","key"]'> [account]
    public String addMultiSigAddress(int nRequired, List<String> publicKeys, String account) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "addmultisigaddress");
    	List<Object> params = new ArrayList<Object>();
    	params.add(nRequired);
    	params.add(publicKeys);
    	params.add(account);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
	
    //backupwallet <destination>
    public String backupWallet(String destination) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "backupwallet");
    	List<Object> params = new ArrayList<Object>();
    	params.add(destination);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //dumpprivkey <dogecoinaddress>
    public String dumpPrivKey(String dogecoinaddress) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "dumpprivkey");
    	List<Object> params = new ArrayList<Object>();
    	params.add(dogecoinaddress);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //encryptwallet <passphrase>
    public String encryptWallet(String passphrase) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "encryptwallet");
    	List<Object> params = new ArrayList<Object>();
    	params.add(passphrase);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getaccount <dogecoinaddress>
    public String getAccount(String dogecoinaddress) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getaccount");
    	List<Object> params = new ArrayList<Object>();
    	params.add(dogecoinaddress);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getaccountaddress <account>
    public String getAccountAddress(String account) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getaccountaddress");
    	List<Object> params = new ArrayList<Object>();
    	params.add(account);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getaddressesbyaccount <account>
    public String getAddressByCount(String account) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getaddressesbyaccount");
    	List<Object> params = new ArrayList<Object>();
    	params.add(account);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //createrawtransaction [{"txid":txid,"vout":n},...] {address:amount,...}
    public String createRawTransaction(List<JSONObject> transactions, JSONObject outputs) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "createrawtransaction");
    	List<Object> params = new ArrayList<Object>();
    	params.add(transactions);
    	params.add(outputs);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //decoderawtransaction <hex string>
    public String decodeRawTransaction(String hexString) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "decoderawtransaction");
    	List<Object> params = new ArrayList<Object>();
    	params.add(hexString);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getinfo
    public String getInfo() throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getinfo");
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getpeerinfo
    public String getPeerInfo() throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getpeerinfo");
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getbalance [account] [minconf=1]
    public String getBalance(String account, String minconf) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getbalance");
    	List<Object> params = new ArrayList<Object>();
    	params.add(account);
    	params.add(minconf);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getblock <hash>
    public String getBlock(String hash) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getblock");
    	List<Object> params = new ArrayList<Object>();
    	params.add(hash);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getblockcount
    public String getBlockCount() throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getblockcount");
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getblockhash <index>
    public String getBlockHash(String index) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getblockhash");
    	List<Object> params = new ArrayList<Object>();
    	params.add(index);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getblocktemplate [params]
    public String getBlockTemplate(String params) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getblocktemplate");
    	List<Object> _params = new ArrayList<Object>();
    	_params.add(params);
    	jsonData.put(PARAMS,  _params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getconnectioncount
    public String getConnectionCount() throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getconnectioncount");
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getdifficulty
    public String getDifficulty() throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getdifficulty");
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getgenerate
    public String getGenerate() throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getgenerate");
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //gethashespersec
    public String getHashesPerSec() throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "gethashespersec");
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getmininginfo
    public String getMiningInfo() throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getmininginfo");
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getnetworkhashps [blocks]
    public String getNetworkHashPs(String blocks) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getnetworkhashps");
    	List<Object> params = new ArrayList<Object>();
    	params.add(blocks);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getnewaddress [account]
    public String getNewAddress(String account) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getnewaddress");
    	List<Object> params = new ArrayList<Object>();
    	params.add(account);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getrawmempool
    public String getRawMemPool() throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getrawmempool");
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getrawtransaction <txid> [verbose=0]
    public String getRawTransaction(String txid, String verbose) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getrawtransaction");
    	List<Object> params = new ArrayList<Object>();
    	params.add(txid);
    	params.add(verbose);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getreceivedbyaccount <account> [minconf=1]
    public String getReceivedByAccount(String account, String minconf) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getreceivedbyaccount");
    	List<Object> params = new ArrayList<Object>();
    	params.add(account);
    	params.add(minconf);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getreceivedbyaddress <dogecoinaddress> [minconf=1]
    public String getReceivedByAddress(String dogecoinaddress, String minconf) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getreceivedbyaddress");
    	List<Object> params = new ArrayList<Object>();
    	params.add(dogecoinaddress);
    	params.add(minconf);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //gettransaction <txid>
    public String getTransaction(String txid) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD,  "gettransaction");
    	List<Object> params = new ArrayList<Object>();
    	params.add(txid);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getwork [data]
    public String getWork(String data) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getwork");
    	List<Object> params = new ArrayList<Object>();
    	params.add(data);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //getworkex [data, coinbase]
    public String getWorkEx(List<String> dataAndCoinbase) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "getworkex");
    	List<Object> params = new ArrayList<Object>();
    	params.add(dataAndCoinbase);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //help [command]
    public String help(String command) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "help");
    	List<Object> params = new ArrayList<Object>();
    	params.add(command);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //importprivkey <dogecoinprivkey> [label]
    public String importPrivKey(String dogecoinprivkey, String label) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "importprivkey");
    	List<Object> params = new ArrayList<Object>();
    	params.add(dogecoinprivkey);
    	params.add(label);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //keypoolrefill
    public String keyPoolRefill() throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "keypoolrefill");
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //listaccounts [minconf=1]
    public String listAccounts(String minconf) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "listaccounts");
    	List<Object> params = new ArrayList<Object>();
    	params.add(minconf);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //listreceivedbyaccount [minconf=1] [includeempty=false]
    public String listReceivedByAccount(String minconf, String includeEmpty) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "listreceivedbyaccount");
    	List<Object> params = new ArrayList<Object>();
    	params.add(minconf);
    	params.add(includeEmpty);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //listreceivedbyaddress [minconf=1] [includeempty=false]
    public String listReceivedByAddress(String minconf, String includeEmpty) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "listreceivedbyaddress");
    	List<Object> params = new ArrayList<Object>();
    	params.add(minconf);
    	params.add(includeEmpty);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //listsinceblock [blockhash] [target-confirmations]
    public String listSinceBlock(String blockHash, String targetConfirmations) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "listsinceblock");
    	List<Object> params = new ArrayList<Object>();
    	params.add(blockHash);
    	params.add(targetConfirmations);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //listtransactions [account] [count=10] [from=0]
    public String listTransactions(String account, String count, String from) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "listtransactions");
    	List<Object> params = new ArrayList<Object>();
    	params.add(account);
    	params.add(count);
    	params.add(from);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //listunspent [minconf=1] [maxconf=999999]
    public String listUnspent(String minconf, String maxconf) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "listunspent");
    	List<Object> params = new ArrayList<Object>();
    	params.add(minconf);
    	params.add(maxconf);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //move <fromaccount> <toaccount> <amount> [minconf=1] [comment]
    public String move(String fromAccount, String toAccount, String amount, String minconf, String comment) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "move");
    	List<Object> params = new ArrayList<Object>();
    	params.add(fromAccount);
    	params.add(toAccount);
    	params.add(amount);
    	params.add(minconf);
    	params.add(comment);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
	// sendfrom <fromaccount> <todogecoinaddress> <amount> [minconf=1] [comment] [comment-to]
	public String sendFrom(String fromAccount, String toDogeCoinAddress,
			String amount, String minconf, String comment, String commentTo) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "sendfrom");
    	List<Object> params = new ArrayList<Object>();
    	params.add(fromAccount);
    	params.add(toDogeCoinAddress);
    	params.add(amount);
    	params.add(minconf);
    	params.add(comment);
    	params.add(commentTo);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //sendmany <fromaccount> {address:amount,...} [minconf=1] [comment]
    public String sendMany(String fromaccount, JSONObject toBitcoinAddresses, String minconf,
    		String comment) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "sendmany");
    	List<Object> params = new ArrayList<Object>();
    	params.add(fromaccount);
    	params.add(toBitcoinAddresses);
    	params.add(minconf);
    	params.add(comment);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //sendrawtransaction <hex string>
    public String sendRawTransation(String hexString) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "sendrawtransaction");
    	List<Object> params = new ArrayList<Object>();
    	params.add(hexString);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //sendtoaddress <dogecoinaddress> <amount> [comment] [comment-to]
	public String sendToAddress(String dogecoinaddress, String amount, String comment,
			String commentTo) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "sendtoaddress");
    	List<Object> params = new ArrayList<Object>();
    	params.add(dogecoinaddress);
    	params.add(amount);
    	params.add(comment);
    	params.add(commentTo);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
    
    //setaccount <dogecoinaddress> <account>
	public String setAccount(String dogecoinaddress, String account) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "setaccount");
    	List<Object> params = new ArrayList<Object>();
    	params.add(dogecoinaddress);
    	params.add(account);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
	
    //setgenerate <generate> [genproclimit]
	public String setGenerate(String generate, String genproclimit) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "setgenerate");
    	List<Object> params = new ArrayList<Object>();
    	params.add(generate);
    	params.add(genproclimit);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
	
    //setmininput <amount>
	public String setGenerate(String amount) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "setmininput");
    	List<Object> params = new ArrayList<Object>();
    	params.add(amount);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
	
    //settxfee <amount>
	public String setTxFee(String amount) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "settxfee");
    	List<Object> params = new ArrayList<Object>();
    	params.add(amount);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
	
    //signmessage <dogecoinaddress> <message>
	public String signMessage(String dogecoinaddress, String message) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "signmessage");
    	List<Object> params = new ArrayList<Object>();
    	params.add(dogecoinaddress);
    	params.add(message);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
	
    //signrawtransaction <hex string> [{"txid":txid,"vout":n,"scriptPubKey":hex},...] [<privatekey1>,...] [sighashtype="ALL"]
	public String signRawTransaction(String transactions, String keys, String sigHashType) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "signrawtransaction");
    	List<Object> params = new ArrayList<Object>();
    	params.add(transactions);
    	params.add(keys);
    	params.add(sigHashType);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
	
    //stop
	public String stop() throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "stop");
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
	
    //validateaddress <dogecoinaddress>
	public String validateAddress(String dogecoinaddress) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "validateaddress");
    	List<Object> params = new ArrayList<Object>();
    	params.add(dogecoinaddress);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
	}
	
    //verifymessage <dogecoinaddress> <signature> <message>
	public String verifyMessage(String dogecoinaddress, String signature, String message) throws Exception {
    	JSONObject jsonData = new JSONObject();
    	jsonData.put(METHOD, "verifymessage");
    	List<Object> params = new ArrayList<Object>();
    	params.add(dogecoinaddress);
    	params.add(signature);
    	params.add(message);
    	jsonData.put(PARAMS,  params);
    	return DogeCoinD.callRPC(username, password, jsonData);
    }
}
