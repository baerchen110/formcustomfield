package com.liferay.dynamic.data.mapping.type.upload;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldValueRequestParameterRetriever;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.upload.UploadServletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = "ddm.form.field.type.name=upload")
public class UploadDDMFormFieldValueRequestParameterRetriever
implements DDMFormFieldValueRequestParameterRetriever {

	@Reference
	protected JSONFactory jsonFactory;
	
	
	@Override
	public String get(HttpServletRequest httpServletRequest, String ddmFormFieldParameterName,
			String defaultDDMFormFieldParameterValue) {
		
		System.out.println("inside");
		// Create path components to save the file
		OutputStream out = null;
		InputStream fileContent = null;
		
		String[] parameterValues = ParamUtil.getParameterValues(
				httpServletRequest, ddmFormFieldParameterName,
				GetterUtil.DEFAULT_STRING_VALUES);
		try {
			//final String path = httpServletRequest.getParameter("destination");
	
		    //String description = httpServletRequest.getParameter("description"); // Retrieves <input type="text" name="description">
		    //String fileName = "/Users/huagechen/Documents/LifeRay/liferay-dxp-digital-enterprise-7.0-ga1/data/upload/"+ getSubmittedFileName(filePart);
		    //InputStream fileContent = filePart.getInputStream();
		    UploadServletRequest uploadServletRequest = PortalUtil.getUploadServletRequest(httpServletRequest); 
		    System.out.println("processing file");
		    
		    String fileName=uploadServletRequest.getFileName("uploadfield");	
		    if (fileName != null){
			    fileName = "/Users/huagechen/Documents/LifeRay/liferay-dxp-digital-enterprise-7.0-ga1/data/upload/" + fileName;
			    System.out.println("filename "+ fileName);
			    
			    File file = uploadServletRequest.getFile("uploadfield");
			    fileContent = new FileInputStream( file );
	            // ... (do your job here)
	            out = new FileOutputStream(new File(fileName));
	
				int read = 0;
				byte[] bytes = new byte[1024];
	
				while ((read = fileContent.read(bytes)) != -1) {
					out.write(bytes, 0, read);
					System.out.println("writing");
				}
		    }
		    // write the inputStream to a FileOutputStream
		  
	        return jsonFactory.serialize(parameterValues);
	    } catch (FileNotFoundException fne) {
	    	fne.printStackTrace();
			return null;
	    }  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
	        if (out != null) {
	            try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        if (fileContent != null) {
	            try {
	            	fileContent.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }

	    }
	}

	private static String getSubmittedFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}
	
	
}
