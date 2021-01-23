package com.allianz.carbondioxidetracker.service.impls;

import org.junit.Ignore;

@Ignore
public class CarbonDioxideDataServiceImplTest {

//    private CarbonDioxideValueAddCommandAdaptor addCommandAdaptor ;
//    private ReadingDao readingDao;
//
//    private CarbonDioxideDataServiceImpl carbonDioxideDataServiceImplUnderTest;
//
//    @Before
//    public void setUp() {
//
//        addCommandAdaptor = Mockito.mock(CarbonDioxideValueAddCommandAdaptor.class) ;
//        readingDao = Mockito.mock(ReadingDao.class) ;
//
//        carbonDioxideDataServiceImplUnderTest = new CarbonDioxideDataServiceImpl();
//
//        carbonDioxideDataServiceImplUnderTest.setAddCommandAdaptor(addCommandAdaptor);
//        carbonDioxideDataServiceImplUnderTest.setCarbonDioxideRepository(readingDao);
//    }
//
//    @Test(expected = IValidationException.class)
//    public void testAddCarbonDioxideValueWithNullCommand() {
//
//        final CarbonDioxideValueAddCommand command = null;
//
//        carbonDioxideDataServiceImplUnderTest.addCarbonDioxideValue(command);
//    }
//
//    @Test
//    public void testAddCarbonDioxideValue() {
//
//        final CarbonDioxideValueAddCommand command = new CarbonDioxideValueAddCommand();
//        command.setSensorId("sensorId");
//        command.setDate("Date");
//        command.setCarbonValue(8);
//
//        final Reading entity = new Reading() ;
//
//        entity.setId("Id");
//        entity.setDate("Date");
//        entity.setCarbonValue("8");
//
//        Mockito.when(addCommandAdaptor.adopt(command)).thenReturn(entity) ;
//        Mockito.when(readingDao.save(entity)).thenReturn(entity) ;
//
//        final CarbonDioxideValueAddResult result = carbonDioxideDataServiceImplUnderTest.addCarbonDioxideValue(command);
//
//        Assertions.assertThat(result).isNotNull() ;
//        Assertions.assertThat(result.getId()).isEqualTo("Id") ;
//        Assertions.assertThat(result.getDate()).isEqualTo("Date") ;
//
//    }
}
