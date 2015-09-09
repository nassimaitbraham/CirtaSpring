//package com.aitech.util;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//
//
//import com.aitech.service.PersonService;
//
//
//
//@ContextConfiguration(locations={
//          "classpath:/META-INF/spring-context.xml"})
//public class AdditionTest {
//
//	protected Addition op;
//
//	@Autowired
//	private PersonService personService;
//
//	
//	@Before
//    public void setUp() {
//        op = new Addition();
//        
//        
//    }
//	
//	@Test
//	public void testCalculer() throws Exception {
//
//		personService.getAll();
//		assertEquals(new Long(4), op.calculer(new Long(1), new Long(3)));
//	}
//
//	
//
//}
