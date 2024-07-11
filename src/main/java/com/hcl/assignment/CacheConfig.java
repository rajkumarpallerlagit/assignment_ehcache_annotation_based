package com.hcl.assignment;

import java.util.concurrent.TimeUnit;

import javax.cache.Caching;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.assignment.model.AuthorBooks;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public CacheManager ehCacheManger()
	{
		
		CacheConfiguration<String, AuthorBooks> cacheConfiguration = 
				CacheConfigurationBuilder.
				newCacheConfigurationBuilder(String.class, AuthorBooks.class, ResourcePoolsBuilder.heap(10))
				.withExpiry(Expirations.timeToLiveExpiration(new Duration(10, TimeUnit.SECONDS))).build();
		
		javax.cache.CacheManager cacheManager = Caching.getCachingProvider("org.ehcache.jsr107.EhcacheCachingProvider").getCacheManager();
		
		String cacheName = "booksCache";
		cacheManager.destroyCache(cacheName);
		cacheManager.createCache(cacheName, Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfiguration));
		return new JCacheCacheManager(cacheManager);
	}
	
}
