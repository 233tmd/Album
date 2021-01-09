package th.component;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * �ļ�ѡ����
 */
public class ViewerFileChooser extends JFileChooser {
	private static final long serialVersionUID = 1L; 
	
	/**
	 * ʹ���û�Ĭ��·������һ��ImageFileChooser
	 * 
	 * @return void
	 */
	public ViewerFileChooser() {
		super();
		//ȥ�������ļ�������
		setAcceptAllFileFilterUsed(false);
		
		// add AcceptAll FileFilter.test by zhongjian 2012.11.21
		//setAcceptAllFileFilterUsed(true);
		// end test
		
		addFilter();
	}

	/**
	 * ʹ���Զ����·��·������һ��ViewerFileChooser
	 * 
	 * @param currentDirectoryPath
	 *            String �Զ���·��
	 * @return void
	 */
	public ViewerFileChooser(String currentDirectoryPath) {
		super(currentDirectoryPath);
		setAcceptAllFileFilterUsed(false);
		addFilter();
	}

	/**
	 * �����ļ�������
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
				".PNG", ".ICO" }, "����ͼ���ļ�"));
	}

	class MyFileFilter extends FileFilter {
		// ��׺������
		String[] suffarr;
		// ����
		String decription;

		public MyFileFilter() {
			super();
		}

		/**
		 * �ð�����׺������������������һ��MyFileFilter
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
		 * ��дboolean accept( File f )����
		 * 
		 * @paream f File
		 * @return boolean
		 */
		@Override
		public boolean accept(File f) {
			// ����ļ��ĺ�׺���Ϸ�������true
			for (String s : suffarr) {
				if (f.getName().toUpperCase().endsWith(s)) {
					return true;
				}
			}
			// �����Ŀ¼������true,���߷���false
			return f.isDirectory();
		}

		/**
		 * ��ȡ������Ϣ
		 * 
		 * @return String
		 */
		public String getDescription() {
			return this.decription;
		}
	}

}