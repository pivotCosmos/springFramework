package kosta.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration //������̼� ����� ȯ�漳���� ���� annotation�̴�. �� Ŭ���� ���ο� @Bean�� ������ �޼ҵ尡 �����ϴ� ��ü�� bean���� ������ش�.
public class TilesConfiguration {

	/**
	 * Tiles���� bean ���
	 * */
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
		urlBasedViewResolver.setOrder(0);
		urlBasedViewResolver.setViewClass(TilesView.class);
		System.out.println("TilesConfiguration�� viewResolver() ȣ���........");
		
		
		return urlBasedViewResolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String [] {"/WEB-INF/tiles/tiles.xml"});
		
		System.out.println("TilesConfigurer�� tilesConfigurer() ȣ���.........");
		return tiles;
	}
	
}
