import net.azib.ipscan.config.ScannerConfig;
import net.azib.ipscan.fetchers.PortTextFetcher;

/**
 * Created by p.elsie on 5/5/2017.
 */


public class SpecialWebDetectFetcher extends PortTextFetcher {
	public SpecialWebDetectFetcher() {
		this(Config.getConfig().forScanner());
	}

	public SpecialWebDetectFetcher(ScannerConfig scannerConfig) {
		super(scannerConfig, 8080, "HEAD /robots.txt HTTP/1.0\r\n\r\n", "^[Ss]erver:\\s+(.*)$");
	}

	public SpecialWebDetectFetcher(ScannerConfig scannerConfig, int defaultPort, String textToSend, String matchingRegexp) {
		super(scannerConfig, defaultPort, textToSend, matchingRegexp);
	}

	@Override
	public String getName() {
		return "Special Web Detect - reads HTTP headers on non-standard port";
	}

	@Override
	public String getId() {
		return "fetcher.specialWebDetect";
	}
}
