package com.exxeta.mca.br;

import java.math.BigDecimal;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import com.exxeta.mca.model.Position;

public class BasicRuleApp {
	
	
	private static  void main(String[] args) {
		KnowledgeBase knowledgeBase = createKnowledgeBase();
		StatefulKnowledgeSession session = knowledgeBase
				.newStatefulKnowledgeSession();
		try {
			Position position = new Position();
			BigDecimal bd = new BigDecimal(12.50);
			position.setAmount(bd);
			session.insert(position);
			session.fireAllRules();
		} finally {
			session.dispose();
		}
	}

	private static KnowledgeBase createKnowledgeBase() {
		KnowledgeBuilder builder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		builder.add(ResourceFactory.newClassPathResource("basicRule.drl"),ResourceType.DRL);
		if (builder.hasErrors()) {
			throw new RuntimeException(builder.getErrors().toString());
		}
		KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
		knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());
		return knowledgeBase;
	}

}
