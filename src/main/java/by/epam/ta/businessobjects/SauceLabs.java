package by.epam.ta.businessobjects;

public class SauceLabs {

    private final String username;

    private final String accessKey;

    private final String url;

    public SauceLabs(String url, String accessKey, String username) {
        this.url = url;
        this.accessKey = accessKey;
        this.username = username;
    }

}
