package th.action;


import th.component.ViewerFrame;
import th.component.ViewerService;

/**
 * 打开图片文件的Action
 */
public class OpenAction implements Action {

	public void execute(ViewerService service, ViewerFrame frame) {
		service.open(frame);
	}

}
