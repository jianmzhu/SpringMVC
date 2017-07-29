package com.alex.springmvc.rssmessage.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Content;
import com.rometools.rome.feed.rss.Item;

public class RSSFeedViewer extends AbstractRssFeedView {
	//需要用到以下jar包
//	rome-utils-1.7.4.jar
//	rome-1.7.4.jar
//	jdom2-2.0.6.jar
	/* (non-Javadoc)
	 * 配置标题头
	 * 
	 * @see org.springframework.web.servlet.view.feed.AbstractFeedView#buildFeedMetadata(java.util.Map, com.rometools.rome.feed.WireFeed, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed,
			HttpServletRequest request) {
		feed.setDocs("yyye");
		feed.setStyleSheet("74");
		feed.setTitle("YiibaiPoint Dot Com");
		feed.setDescription("Java Yiibai and Examples");
		feed.setLink("http://www.yiibai.com");
		super.buildFeedMetadata(model, feed, request);
	}

	/* (non-Javadoc)
	 * 设置主要内容
	 * 
	 * @see org.springframework.web.servlet.view.feed.AbstractRssFeedView#buildFeedItems(java.util.Map, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<RSSMessage> listContent = (List<RSSMessage>) model
				.get("feedContent");
		List<Item> items = new ArrayList<Item>(listContent.size());
		for (RSSMessage tempContent : listContent) {
			Item item = new Item();
			Content content = new Content();
			content.setValue(tempContent.getSummary());
			item.setContent(content);
			item.setTitle(tempContent.getTitle());
			item.setLink(tempContent.getUrl());
			item.setPubDate(tempContent.getCreatedDate());
			items.add(item);
		}
		return items;
	}
}