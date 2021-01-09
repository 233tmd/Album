package th.component;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Image;
import java.io.File;
import javax.swing.filechooser.FileFilter;


import java.util.List;
import java.util.ArrayList;

/**
 * 图片浏览器业务类
 */
public class ViewerService {
	private static ViewerService service = null;
	private ViewerFileChooser fileChooser = new ViewerFileChooser();// 新建一个ViewerFileChooser
	private double range = 0.2;// 放大或者缩小的比例
	private File currentDirectory = null;	// 目前的文件夹
	private List<File> currentFiles = null;	// 目前文件夹下的所有图片文件	
	private File currentFile = null;// 目前图片文件

	/**
	 * 私有构造器
	 */
	private ViewerService() {
	}

	/**
	 * 获取单态实例
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
	 * 打开图片
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @return void
	 */
	public void open(ViewerFrame frame) {
		//fileChooser.showOpenDialog()弹出打开文件对话框,返回int
		// 如果选择打开
		if (ViewerFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(frame)) {
			// 给目前打开的文件赋值
			this.currentFile = fileChooser.getSelectedFile();
			// 获取文件路径
			String name = this.currentFile.getPath();
			// 获取目前文件夹
			File cd = fileChooser.getCurrentDirectory();
			
			// 如果文件夹有改变
			if (cd != this.currentDirectory || null == this.currentDirectory) {
				// 或者fileChooser的所有FileFilter
				FileFilter[] fileFilters = fileChooser.getChoosableFileFilters();
				File files[] = cd.listFiles();
				this.currentFiles = new ArrayList<File>();
				for (File file : files) {
					for (FileFilter filter : fileFilters) {
						// 如果是图片文件
						if (filter.accept(file)) {
							// 把文件加到currentFiles中
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
	 * 放大缩小
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @return void
	 */
	public void zoom(ViewerFrame frame, boolean isEnlarge) {
		// 获取放大或者缩小的乘比
		double enLargeRange = isEnlarge ? 1 + range : 1 - range;
		// 获取目前的图片
		ImageIcon icon = (ImageIcon) frame.getLabel().getIcon();
		
		if (icon != null) {
			int width = (int) (icon.getIconWidth() * enLargeRange);
			// 获取改变大小后的图片,高宽其中之一为负，维持初始图像尺寸的高宽比
			ImageIcon newIcon = new ImageIcon(icon.getImage()
					.getScaledInstance(width, -1,/* Image.SCALE_DEFAULT*/Image.SCALE_SMOOTH));
			// 改变显示的图片
			frame.getLabel().setIcon(newIcon);
		}
	}

	/**
	 * 上一个
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @return void
	 */
	public void last(ViewerFrame frame) {
		// 如果有打开包含图片的文件夹
		if (this.currentFiles != null && !this.currentFiles.isEmpty()) {
			int index = this.currentFiles.indexOf(this.currentFile);
			// 打开上一个
			if (index > 0) {
				File file = (File) this.currentFiles.get(index - 1);
				ImageIcon icon = new ImageIcon(file.getPath());
				frame.getLabel().setIcon(icon);
				this.currentFile = file;
			}
		}
	}

	/**
	 * 下一个
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @return void
	 */
	public void next(ViewerFrame frame) {
		// 如果有打开包含图片的文件夹
		if (this.currentFiles != null && !this.currentFiles.isEmpty()) {
			int index = this.currentFiles.indexOf(this.currentFile) + 1;
			// 打开下一个
			if (index + 1 < this.currentFiles.size()) {
				File file = (File) this.currentFiles.get(index + 1);
				ImageIcon icon = new ImageIcon(file.getPath());
				frame.getLabel().setIcon(icon);
				this.currentFile = file;
			}
		}
	}

	/**
	 * 响应菜单的动作
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @param cmd
	 *            String
	 * @return void
	 */
	public void menuDo(ViewerFrame frame, String cmd) {
		// 打开
		if (cmd.equals("打开(O)")) {
			open(frame);
		}
		// 放大
		else if (cmd.equals("放大(M)")) {
			zoom(frame, true);
		}
		// 缩小
		else if (cmd.equals("缩小(O)")) {
			zoom(frame, false);
		}
		// 上一个
		else if (cmd.equals("上一个(X)")) {
			last(frame);
		}
		// 下一个
		else if (cmd.equals("下一个(P)")) {
			next(frame);
		}
		else if(cmd.equals("帮助主题")){
			JOptionPane.showMessageDialog(frame, "友情提示:暂无可用帮助！");
		}
		// 退出
		else if (cmd.equals("退出(X)")) {
			System.exit(0);
		}
	}
}