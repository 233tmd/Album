package th.component;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * 文件选择器
 */
public class ViewerFileChooser extends JFileChooser {
	private static final long serialVersionUID = 1L; 
	
	/**
	 * 使用用户默认路径创建一个ImageFileChooser
	 * 
	 * @return void
	 */
	public ViewerFileChooser() {
		super();
		//去掉所有文件过滤器
		setAcceptAllFileFilterUsed(false);
		
		// add AcceptAll FileFilter.test by zhongjian 2012.11.21
		//setAcceptAllFileFilterUsed(true);
		// end test
		
		addFilter();
	}

	/**
	 * 使用自定义的路径路径创建一个ViewerFileChooser
	 * 
	 * @param currentDirectoryPath
	 *            String 自定义路径
	 * @return void
	 */
	public ViewerFileChooser(String currentDirectoryPath) {
		super(currentDirectoryPath);
		setAcceptAllFileFilterUsed(false);
		addFilter();
	}

	/**
	 * 增加文件过滤器
	 * 
	 * @return void
	 */
	private void addFilter() {
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".BMP" },
				"BMP (*.BMP)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".JPG",
						".JPEG", ".JPE", ".JFIF" },
						"JPEG (*.JPG;*.JPEG;*.JPE;*.JFIF)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".GIF" },
				"GIF (*.GIF)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".TIF",
				".TIFF" }, "TIFF (*.TIF;*.TIFF)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".PNG" },
				"PNG (*.PNG)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".ICO" },
				"ICO (*.ICO)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".BMP",
				".JPG", ".JPEG", ".JPE", ".JFIF", ".GIF", ".TIF", ".TIFF",
				".PNG", ".ICO" }, "所有图形文件"));
	}

	class MyFileFilter extends FileFilter {
		// 后缀名数组
		String[] suffarr;
		// 描述
		String decription;

		public MyFileFilter() {
			super();
		}

		/**
		 * 用包含后缀名的数组与描述创建一个MyFileFilter
		 * 
		 * @param suffarr
		 *            String[]
		 * @param decription
		 *            String
		 * @return void
		 */
		public MyFileFilter(String[] suffarr, String decription) {
			super();
			this.suffarr = suffarr;
			this.decription = decription;
		}

		/**
		 * 重写boolean accept( File f )方法
		 * 
		 * @paream f File
		 * @return boolean
		 */
		@Override
		public boolean accept(File f) {
			// 如果文件的后缀名合法，返回true
			for (String s : suffarr) {
				if (f.getName().toUpperCase().endsWith(s)) {
					return true;
				}
			}
			// 如果是目录，返回true,或者返回false
			return f.isDirectory();
		}

		/**
		 * 获取描述信息
		 * 
		 * @return String
		 */
		public String getDescription() {
			return this.decription;
		}
	}

}