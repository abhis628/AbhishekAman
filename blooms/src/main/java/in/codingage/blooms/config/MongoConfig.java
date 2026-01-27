package in.codingage.blooms.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    //properties file se URL utha raha hai
     @Value("${spring.data.mongodb.uri}")
    private  String mongoUri;
      @Bean
     public MongoClient mongoClient(){
         //Ye console me print karega taaki humein pata Chale connection
         System.out.println("\uD83D\uDE80 INITIALIZING MONGODB CONNECTION WITH URI...");

         ConnectionString connectionString=new ConnectionString(mongoUri);

         MongoClientSettings settings= MongoClientSettings.builder()
                 .applyConnectionString(connectionString).build();
         return MongoClients.create(settings);
     }
     @Bean
    public MongoTemplate mongoTemplate(){
          return  new MongoTemplate(mongoClient(),"blooms_db");
     }



}
