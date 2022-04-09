package bitcoin.dexbitcoin.data.currentprice

import bitcoin.dexbitcoin.Coindesk
import bitcoin.dexbitcoin.SafeApiRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoinRepository : SafeApiRequest() {

    var coindesk: Coindesk? = null

    suspend fun getCoindeskExchangeRates() {
        withContext(Dispatchers.IO) {
            val coindeskFromApi: Coindesk = apiRequest { CoinApi().getCoindeskObject() }

            coindesk = coindeskFromApi
        }
    }


}