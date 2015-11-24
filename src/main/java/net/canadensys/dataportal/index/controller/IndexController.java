package net.canadensys.dataportal.index.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.canadensys.dataportal.occurrence.OccurrenceService;
import net.canadensys.dataportal.occurrence.config.OccurrencePortalConfig;
import net.canadensys.dataportal.occurrence.controller.ControllerHelper;
import net.canadensys.dataportal.occurrence.model.DwcaResourceModel;
import net.canadensys.dataportal.occurrence.model.ResourceMetadataModel;
import net.canadensys.dataportal.resource.service.ResourceService;
import net.canadensys.exception.web.ResourceNotFoundException;
import net.canadensys.web.i18n.annotation.I18nTranslation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller of all Index related features of the explorer.
 * 
 * @author Pedro Guimarães
 * 
 */
@Controller
public class IndexController {


	// get log4j handler
	private static final Logger LOGGER = Logger
			.getLogger(IndexController.class);

	@Autowired
	@Qualifier("occurrencePortalConfig")
	private OccurrencePortalConfig appConfig;

	/**
	 * Display a simple index page.
	 * 
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@I18nTranslation(resourceName = "index", translateFormat = "/index")
	public ModelAndView handleIndex(HttpServletRequest request) {
		HashMap<String, Object> modelRoot = new HashMap<String, Object>();
		
		return new ModelAndView("index",
				OccurrencePortalConfig.PAGE_ROOT_MODEL_KEY, modelRoot);
	}
}