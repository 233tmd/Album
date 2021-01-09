package th.component;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Image;
import java.io.File;
import javax.swing.filechooser.FileFilter;


import java.util.List;
import java.util.ArrayList;

/**
 * ͼƬ�����ҵ����
 */
public class ViewerService {
	private static ViewerService service = null;
	private ViewerFileChooser fileChooser = new ViewerFileChooser();// �½�һ��ViewerFileChooser
	private double range = 0.2;// �Ŵ������С�ı���
	private File currentDirectory = null;	// Ŀǰ���ļ���
	private List<File> currentFiles = null;	// Ŀǰ�ļ����µ�����ͼƬ�ļ�	
	private File currentFile = null;// ĿǰͼƬ�ļ�

	/**
	 * ˽�й�����
	 */
	private ViewerService() {
	}

	/**
	 * ��ȡ��̬ʵ��
	 * 
	 * @return ViewerService
	 */
	public static ViewerService getInstance() {
		if (null == service) {
			service = new ViewerService();
		}
		
		return service;
	}

	/**
	 * ��ͼƬ
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @return void
	 */
	public void open(ViewerFrame frame) {
		//fileChooser.showOpenDialog()�������ļ��Ի���,����int
		// ���ѡ���
		if (ViewerFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(frame)) {
			// ��Ŀǰ�򿪵��ļ���ֵ
			this.currentFile = fileChooser.getSelectedFile();
			// ��ȡ�ļ�·��
			String name = this.currentFile.getPath();
			// ��ȡĿǰ�ļ���
			File cd = fileChooser.getCurrentDirectory();
			
			// ����ļ����иı�
			if (cd != this.currentDirectory || null == this.currentDirectory) {
				// ����fileChooser������FileFilter
				FileFilter[] fileFilters = fileChooser.getChoosableFileFilters();
				File files[] = cd.listFiles();
				this.currentFiles = new ArrayList<File>();
				for (File file : files) {
					for (FileFilter filter : fileFilters) {
						// �����ͼƬ�ļ�
						if (filter.accept(file)) {
							// ���ļ��ӵ�currentFiles��
							this.currentFiles.add(file);
						}
					}
				}
			}
			
			ImageIcon icon = new ImageIcon(name);
			frame.getLabel().setIcon(icon);
		}
	}

	/**
	 * �Ŵ���С
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @return void
	 */
	public void zoom(ViewerFrame frame, boolean isEnlarge) {
		// ��ȡ�Ŵ������С�ĳ˱�
		double enLargeRange = isEnlarge ? 1 + range : 1 - range;
		// ��ȡĿǰ��ͼƬ
		ImageIcon icon = (ImageIcon) frame.getLabel().getIcon();
		
		if (icon != null) {
			int width = (int) (icon.getIconWidth() * enLargeRange);
			// ��ȡ�ı��С���ͼƬ,�߿�����֮һΪ����ά�ֳ�ʼͼ��ߴ�ĸ߿��
			ImageIcon newIcon = new ImageIcon(icon.getImage()
					.getScaledInstance(width, -1,/* Image.SCALE_DEFAULT*/Image.SCALE_SMOOTH));
			// �ı���ʾ��ͼƬ
			frame.getLabel().setIcon(newIcon);
		}
	}

	/**
	 * ��һ��
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @return void
	 */
	public void last(ViewerFrame frame) {
		// ����д򿪰���ͼƬ���ļ���
		if (this.currentFiles != null && !this.currentFiles.isEmpty()) {
			int index = this.currentFiles.indexOf(this.currentFile);
			// ����һ��
			if (index > 0) {
				File file = (File) this.currentFiles.get(index - 1);
				ImageIcon icon = new ImageIcon(file.getPath());
				frame.getLabel().setIcon(icon);
				this.currentFile = file;
			}
		}
	}

	/**
	 * ��һ��
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @return void
	 */
	public void next(ViewerFrame frame) {
		// ����д򿪰���ͼƬ���ļ���
		if (this.currentFiles != null && !this.currentFiles.isEmpty()) {
			int index = this.currentFiles.indexOf(this.currentFile) + 1;
			// ����һ��
			if (index + 1 < this.currentFiles.size()) {
				File file = (File) this.currentFiles.get(index + 1);
				ImageIcon icon = new ImageIcon(file.getPath());
				frame.getLabel().setIcon(icon);
				this.currentFile = file;
			}
		}
	}

	/**
	 * ��Ӧ�˵��Ķ���
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @param cmd
	 *            String
	 * @return void
	 */
	public void menuDo(ViewerFrame frame, String cmd) {
		// ��
		if (cmd.equals("��(O)")) {
			open(frame);
		}
		// �Ŵ�
		else if (cmd.equals("�Ŵ�(M)")) {
			zoom(frame, true);
		}
		// ��С
		else if (cmd.equals("��С(O)")) {
			zoom(frame, false);
		}
		// ��һ��
		else if (cmd.equals("��һ��(X)")) {
			last(frame);
		}
		// ��һ��
		else if (cmd.equals("��һ��(P)")) {
			next(frame);
		}
		else if(cmd.equals("��������")){
			JOptionPane.showMessageDialog(frame, "������ʾ:���޿��ð�����");
		}
		// �˳�
		else if (cmd.equals("�˳�(X)")) {
			System.exit(0);
		}
	}
}