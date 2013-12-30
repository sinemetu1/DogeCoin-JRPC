package com.dogecoinjrpc.api;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.dogecoinjrpc.api.Wallet;

public class WalletTest {
	private static Logger log = Logger.getLogger(WalletTest.class);

    private final static int version = 60400;
    private final static int protocolVersion = 60003;
    private final static int walletVersion = 60000;

	
	@Test
	public void testGetInfo() throws Exception {
		Wallet w = new Wallet();
		String actual = w.getInfo();
		JSONObject actualJSONObject = new JSONObject(actual);
		assertEquals(JSONObject.NULL, actualJSONObject.get("error"));
		JSONObject result = actualJSONObject.getJSONObject("result");
		assertEquals(version, result.getInt("version"));
		assertEquals(protocolVersion, result.getInt("protocolversion"));
		assertEquals(walletVersion, result.getInt("walletversion"));
		assertEquals(0.00000000, result.getDouble("balance"), 0);
		assertEquals("", result.getString("errors"));
	}

	@Test
	public void testGetPeerInfo() throws Exception {
		Wallet w = new Wallet();
		String actual = w.getPeerInfo();
		JSONObject actualJSONObject = new JSONObject(actual);
		assertEquals(JSONObject.NULL, actualJSONObject.get("error"));
        JSONArray result = actualJSONObject.getJSONArray("result");
        for (int idx = 0; idx < result.length(); idx++) {
            JSONObject curr = result.getJSONObject(idx);
            assertTrue(curr.getInt("version") > 0);
            assertTrue(curr.getInt("banscore") >= 0);
            curr.getBoolean("inbound"); // should be able to get
        }
	}
	
	@Test
	public void testGetBlockCount() throws Exception {
		Wallet w = new Wallet();
		String actual = w.getBlockCount();
		JSONObject actualJSONObject = new JSONObject(actual);
		assertEquals(JSONObject.NULL, actualJSONObject.get("id"));
		assertEquals(JSONObject.NULL, actualJSONObject.get("error"));
		assertTrue(actualJSONObject.getInt("result") >= 0);
    }

	@Test
	public void testGetConnectionCount() throws Exception {
		Wallet w = new Wallet();
		String actual = w.getConnectionCount();
		JSONObject actualJSONObject = new JSONObject(actual);
		assertEquals(JSONObject.NULL, actualJSONObject.get("error"));
		assertEquals(JSONObject.NULL, actualJSONObject.get("id"));
		assertTrue(actualJSONObject.getInt("result") >= 0);
    }

	@Test
	public void testGetDifficulty() throws Exception {
		Wallet w = new Wallet();
		String actual = w.getDifficulty();
		JSONObject actualJSONObject = new JSONObject(actual);
		assertEquals(JSONObject.NULL, actualJSONObject.get("error"));
		assertEquals(JSONObject.NULL, actualJSONObject.get("id"));
		assertTrue(actualJSONObject.getInt("result") >= 0);
    }

	@Test
	public void testGetGenerate() throws Exception {
		Wallet w = new Wallet();
		String actual = w.getDifficulty();
		JSONObject actualJSONObject = new JSONObject(actual);
		assertEquals(JSONObject.NULL, actualJSONObject.get("error"));
		assertEquals(JSONObject.NULL, actualJSONObject.get("id"));
		assertTrue(actualJSONObject.getInt("result") >= 0);
    }

    @Test
    public void testGetHashesPerSec() throws Exception {
		Wallet w = new Wallet();
		String actual = w.getHashesPerSec();
		JSONObject actualJSONObject = new JSONObject(actual);
		assertEquals(JSONObject.NULL, actualJSONObject.get("error"));
		assertEquals(JSONObject.NULL, actualJSONObject.get("id"));
		assertTrue(actualJSONObject.getInt("result") >= 0);
    }

    @Test
    public void testGetMiningInfo() throws Exception {
		Wallet w = new Wallet();
		String actual = w.getMiningInfo();
		JSONObject actualJSONObject = new JSONObject(actual);
		JSONObject result = actualJSONObject.getJSONObject("result");
        assertEquals(JSONObject.NULL, actualJSONObject.get("error"));
        assertEquals(JSONObject.NULL, actualJSONObject.get("id"));
		assertTrue(result.getInt("pooledtx") >= 0);
		assertEquals("", result.getString("errors"));
		assertTrue(result.getInt("currentblocktx") >= 0);
		assertEquals(false, result.getBoolean("generate"));
		assertEquals(false, result.getBoolean("testnet"));
		assertTrue(result.getInt("currentblocksize") >= 0);
		assertTrue(result.getInt("hashespersec") >= 0);
		assertTrue(result.getDouble("difficulty") >= 0);
		assertTrue(result.getDouble("blocks") >= 0);
		assertTrue(result.getLong("networkhashps") >= 0);
    }

    @Test
    public void testGetRawMemPool() throws Exception {
		Wallet w = new Wallet();
		String actual = w.getRawMemPool();
		JSONObject actualJSONObject = new JSONObject(actual);
        assertEquals(JSONObject.NULL, actualJSONObject.get("error"));
        assertEquals(JSONObject.NULL, actualJSONObject.get("id"));
		JSONArray result = actualJSONObject.getJSONArray("result");
        for (int idx = 0; idx < result.length(); idx++) {
            String pool = result.getString(idx);
            assertTrue(!pool.equals(""));
        }
    }

    @Test
    public void testHelp() throws Exception {
		Wallet w = new Wallet();
		String actual = w.help("");
		JSONObject actualJSONObject = new JSONObject(actual);
        assertEquals(JSONObject.NULL, actualJSONObject.get("id"));
		String result = actualJSONObject.getString("result");
        assertTrue(!result.equals(""));
    }

    @Test
    public void testKeyPoolRefill() throws Exception {
		Wallet w = new Wallet();
		String actual = w.keyPoolRefill();
		JSONObject actualJSONObject = new JSONObject(actual);
        assertEquals(JSONObject.NULL, actualJSONObject.get("id"));
        assertEquals(JSONObject.NULL, actualJSONObject.get("result"));
        assertEquals(JSONObject.NULL, actualJSONObject.get("error"));
    }
}
