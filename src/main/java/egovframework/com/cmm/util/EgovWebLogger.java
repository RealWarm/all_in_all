package egovframework.com.cmm.util;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import egovframework.com.sym.log.wlg.service.WebLog;
import egovframework.com.sym.log.wlg.service.impl.WebLogDAO;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

@Service("egovWebLogger")
public class EgovWebLogger {

	@Resource(name="webLogDAO")
	private WebLogDAO webLogDAO;
	
   /** ID Generation */
	@Resource(name="egovWebLogIdGnrService")
	private EgovIdGnrService egovWebLogIdGnrService;
	
	@Async
	public void logInsertWebLog(WebLog webLog) throws Exception {
		String requstId = egovWebLogIdGnrService.getNextStringId();
		webLog.setRequstId(requstId);

		webLogDAO.logInsertWebLog(webLog);
	}
	
}