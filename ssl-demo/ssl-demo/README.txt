To configure web application to run on SSL (HTTPS) with self-signed certificate

# Create your own self signed SSL certificate

keytool -genkey -alias selfsigned_localhost_sslserver -keyalg RSA -keysize 2048 -validity 700 -keypass changeit -storepass changeit -keystore ssl-server.jks

# To view what is inside this keystore 
keytool -list -keystore ssl-server.jks


### Reference Documentation
For further reference, please consider the following sections:

* https://howtodoinjava.com/spring-boot/spring-boot-ssl-https-example/


