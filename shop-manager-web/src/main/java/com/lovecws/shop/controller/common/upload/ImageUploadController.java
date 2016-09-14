package com.lovecws.shop.controller.common.upload;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lovecws.common.core.utils.UploadUtil;

@Controller
@RequestMapping("/common/upload")
public class ImageUploadController {

	//@Autowired
	//FDFSAttachmentService attachmentService;
	
	@RequestMapping(value = "/img", method = RequestMethod.POST)
	@ResponseBody
	public String img(HttpServletRequest request) {
		System.out.println("upload img");
		String upload=null;
		try {
			List<String> uploadImage = UploadUtil.uploadImage(request);
			for (String filePath : uploadImage) {
				//upload = attachmentService.upload(filePath);
			}
			System.out.println(upload);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return upload;
	}
}
