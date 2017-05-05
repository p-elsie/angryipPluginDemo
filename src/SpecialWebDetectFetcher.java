import net.azib.ipscan.config.ScannerConfig;
import net.azib.ipscan.fetchers.PortTextFetcher;

/**
 * Created by Patrick Cunningham on 5/5/2017.
 */


public class SpecialWebDetectFetcher extends PortTextFetcher {
	public SpecialWebDetectFetcher() {
		this(null);
	}

	public SpecialWebDetectFetcher(ScannerConfig scannerConfig) {
		super(scannerConfig, 80, "HEAD /robots.txt HTTP/1.0\r\n\r\n", "^[Ss]erver:\\s+(.*)$");
	}

	public SpecialWebDetectFetcher(ScannerConfig scannerConfig, int defaultPort, String textToSend, String matchingRegexp) {
		super(scannerConfig, defaultPort, textToSend, matchingRegexp);
	}


	@Override
	public String getId() {
		return "fetcher.webDetect";
	}
}
