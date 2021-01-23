package com.allianz.carbondioxidetracker.service.impls;

//@Service
class CarbonDioxideDataServiceImpl /* implements CarbonDioxideDataService */{

//	private CarbonDioxideValueAddCommandAdaptor addCommandAdaptor ;
//	private ReadingDao readingDao;
//
//
//	@Override
//	public CarbonDioxideValueAddResult addCarbonDioxideValue(CarbonDioxideValueAddCommand command) {
//
//		if (IEmptyValidation.isEmpty(command)) {
//			throw IValidationException.withMessage(ErrorMessages.NULL_COMMAND) ;
//		}
//
//		final Reading savedEntity = readingDao.save(addCommandAdaptor.adopt(command));
//
//		return CarbonDioxideValueAddResult.builder()
//				.setId(savedEntity.getId())
//				.setDate(savedEntity.getTime())
//				.build() ;
//	}
//
////	public JSONPObject addDevice() {
////		return null;
////
////	}
//
//	@Autowired
//	void setCarbonDioxideRepository(ReadingDao repository) {
//		this.readingDao = repository;
//	}
//
//	@Autowired
//	public void setAddCommandAdaptor(CarbonDioxideValueAddCommandAdaptor adaptor) {
//		this.addCommandAdaptor = adaptor;
//	}
}
