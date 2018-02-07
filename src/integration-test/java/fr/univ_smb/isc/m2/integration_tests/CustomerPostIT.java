package fr.univ_smb.isc.m2.integration_tests;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;


public class CustomerPostIT {


    @Test
    public void should_200_On_Customer_Creation() throws IOException, URISyntaxException {

        HttpPost httpPost = new HttpPost(new URL("http://localhost:" + 9135 + "/api/customers").toURI());
        ArrayList<NameValuePair> postParameters = new ArrayList<>();
        postParameters.add(new BasicNameValuePair("firstName", "Nesbø"));
        postParameters.add(new BasicNameValuePair("lastName", "Ødegård"));
        httpPost.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));
        HttpResponse response = HttpClientBuilder.create().build().execute(httpPost);

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);

    }

}
