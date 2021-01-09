package th.action;

import java.awt.event.ActionEvent;
//import java.util.HashMap;
//import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import th.component.ViewerFrame;
import th.component.ViewerService;


/**
 * ��������Action��
 * @SuppressWarnings������serial����
 */
@SuppressWarnings("serial")
public class ToolPanelAction extends AbstractAction {
	private String actionName = "";
	private ViewerFrame frame = null;
	
	//�����������AbstractAction����Ӧ��th.action����ĳ��Action
	private Action action = null;

	/**
	 * ������
	 * 
	 */
	public ToolPanelAction() {
		// ���ø�������
		super();
	}

	/**
	 * ������
	 * 
	 * @param icon
	 *            ImageIcon ͼ��
	 * @param name
	 *            String
	 */
	public ToolPanelAction(ImageIcon icon, String actionName, ViewerFrame frame) {
		// ���ø�������
		super("", icon);
		this.actionName = actionName;
		this.frame = frame;
	}

	/**
	 * ��дvoid actionPerformed( ActionEvent e )����
	 * 
	 * @param e
	 *            ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ViewerService service = ViewerService.getInstance();
		Action action = getAction(this.actionName);
		//����Action��execute����
		action.execute(service, frame);
	}
	
	/**
	 * ͨ��actionName�õ������ʵ��
	 * @param actionName
	 * @return
	 */
	private Action getAction(String actionName) {
		try {
			if (this.action == null) {
				//����Actionʵ��
				Action action = (Action)Class.forName(actionName).newInstance();
				this.action = action;
			}
			return this.action;
		} catch (Exception e) {
			return null;
		}
	}	
	
}