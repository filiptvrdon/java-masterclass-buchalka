package sk.filiptvrdon;

import javax.print.attribute.URISyntax;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        try {
//            URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
//            System.out.println("Scheme: " + uri.getScheme());
//            System.out.println("Scheme-specific part: " + uri.getSchemeSpecificPart());
//            System.out.println("Authority: " + uri.getAuthority());
//            System.out.println("User info: " + uri.getUserInfo());
//            System.out.println("Host: " + uri.getHost());
//            System.out.println("Port: " + uri.getPort());
//            System.out.println("Path: " + uri.getPath());
//            System.out.println("Query: " + uri.getQuery());
//            System.out.println("Fragment: " + uri.getFragment());
//
//
//            uri = new URI("http://www.filiptvrdon.sk");
//            URL url = uri.toURL();
//            System.out.println("URL: " + url);

            URI baseUri = new URI("http://www.filiptvrdon.sk");
            URI uri = new URI("/catalogue/phones?os=android#samsung");
            URI resolvedUri = baseUri.resolve(uri);
            URL url = resolvedUri.toURL();
            System.out.println("URL: " + url);

        } catch (URISyntaxException e) {
            System.out.println("URI Bad Syntax: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("URL Malformed: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("URI Bad Syntax: " + e.getMessage());
        }


    }
}