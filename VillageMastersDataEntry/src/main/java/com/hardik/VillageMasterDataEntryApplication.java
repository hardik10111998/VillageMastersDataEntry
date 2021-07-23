package com.hardik;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ResourceLoader;

import com.hardik.model.BlockMaster;
import com.hardik.model.DistrictMaster;
import com.hardik.model.StateMaster;
import com.hardik.model.SubDistrictMaster;
import com.hardik.model.VillageMaster;
import com.hardik.repository.BlockMasterRepository;
import com.hardik.repository.DistrictMasterRepository;
import com.hardik.repository.StateMasterRepository;
import com.hardik.repository.SubDistrictMasterRepository;
import com.hardik.repository.VillageMasterRepository;
import com.hardik.util.DateUtil;

@SpringBootApplication
public class VillageMasterDataEntryApplication implements CommandLineRunner {

	@Autowired
	ResourceLoader resourceLoader;
	@Autowired
	BlockMasterRepository blockMasterRepository;
	@Autowired
	DistrictMasterRepository districtMasterRepository;
	@Autowired
	StateMasterRepository stateMasterRepository;
	@Autowired
	SubDistrictMasterRepository subDistrictMasterRepository;
	@Autowired
	VillageMasterRepository villageMasterRepository;

	public static void main(String[] args) {
		SpringApplication.run(VillageMasterDataEntryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.err.println("---------------------------------");
		for (int i = 1; i < 8; i++) {
			File file = new File("D:\\7 parts\\Lg_Village (" + i + ").xlsx");
			System.err.println("---------------------------------");
			System.err.println(file.getName());
			System.err.println("---------------------------------");
			villageMaster(file);
		}
		System.err.println("---------------------------------");

//		File file = new File("D:\\7 parts\\Orginal\\Lg_Village (1).xlsx");
		
//		File file = new File("D:\\7 parts\\Lg_Village (8).xlsx");
//		System.err.println(file.getName());
//		villageMaster(file);

	}

//	------for block---
	@SuppressWarnings("resource")
	public void createBlockFromCSV() {
		try {

			Long districtCode = null;
			Integer subDistrictCode = null;
			Integer blockCode = null;
			Integer blockVersion;
			String blockName;
			String dtShortName;

			boolean active = true;

			File file = new File("D:\\Lg_Block.xlsx"); // creating
														// instance
			FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
			Iterator<Row> itr = sheet.iterator(); // iterating over excel file

			itr.next();// skipping header row
			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column

				districtCode = null;
				subDistrictCode = null;
				blockCode = null;
				blockVersion = null;
				blockName = null;
				dtShortName = null;
				active = true;

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					if (cell.getColumnIndex() == 0) {

					} else if (cell.getColumnIndex() == 1) {
						int i = (int) cell.getNumericCellValue();
						Integer var = Integer.valueOf(i);
						districtCode = var.longValue();
					} else if (cell.getColumnIndex() == 3) {

						int i = (int) cell.getNumericCellValue();
						subDistrictCode = Integer.valueOf(i);

					} else if (cell.getColumnIndex() == 4) {

						int i = (int) cell.getNumericCellValue();
						blockCode = Integer.valueOf(i);

					} else if (cell.getColumnIndex() == 5) {

						int i = (int) cell.getNumericCellValue();
						blockVersion = Integer.valueOf(i);

					} else if (cell.getColumnIndex() == 6) {
						blockName = cell.getStringCellValue();
					} else if (cell.getColumnIndex() == 8) {
						dtShortName = cell.getStringCellValue();
					}

				}

				DistrictMaster districtMaster = districtMasterRepository.findByDistrictCode(districtCode);
				SubDistrictMaster subDistrictMaster = subDistrictMasterRepository.getBySubDistrictCode(subDistrictCode);

				BlockMaster blockMaster = new BlockMaster();
				blockMaster.setActive(active);
				blockMaster.setBlockVersion(blockVersion);
				blockMaster.setDistrictMaster(districtMaster);
				blockMaster.setDtShortName(dtShortName);
				blockMaster.setSubDistrictMaster(subDistrictMaster);
				blockMaster.setBlockCode(blockCode);
				blockMaster.setBlockName(blockName);
				System.out.println(blockMaster.toString());
				System.out.println("======================================================================");
				blockMasterRepository.save(blockMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	------------------

	public Object findCellValue(Cell cell) {
		Object obj = null;
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING: // field that represents string cell type
			String string = cell.getStringCellValue();
			if (string.equals("NULL")) {
//				return null;
			} else {
				obj = string;
			}
			break;
		case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
			Integer numeric = (int) cell.getNumericCellValue();

			obj = numeric;
			break;
		}
		return obj;
	}

	public Object findCellValueVillageName(Cell cell) {
		Object obj = null;
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING: // field that represents string cell type
			String string = cell.getStringCellValue();
			if (string.equals("NULL")) {
//				return null;
			} else {
				obj = string;
			}
			break;
		case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
			Integer numeric = (int) cell.getNumericCellValue();
			if (numeric == 0) {
				Date date = (Date) cell.getDateCellValue();
				obj = DateUtil.convertTimeToString(date);
			} else {
				obj = numeric;
			}

			break;
		}
		return obj;
	}

	public void villageMaster(File file) {
		String panchayatName = null, villageName = null;
		Long DistrictCode = 0L;
		Integer stateCode = 0, distCode = null, subDistCode = null, blockCode = null, villageCode = null,
				census2011Code = null, villageCodeLg = null, panchayatCode = null;

		StateMaster stateMaster = null;
		DistrictMaster districtMaster = null;
		SubDistrictMaster subDistrictMaster = null;
		BlockMaster blockMaster = null;
		;
//		VillageMaster villageMaster;
		try {
//			Resource resource = resourceLoader.getResource("classpath:Lg_Village.xlsx");
//			File file = null;
//			try {
//				file = resource.getFile();// creating instance
////				System.out.println(inputFile.getAbsolutePath().toString());
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
////			File is found
//			System.out.println("File Found : " + file.exists());

//			obtaining bytes from the file creating Workbook instance that refers to .xlsx file
//			File file = new File("D:\\Lg_Village_0.xlsx");
//			File file = new File("D:\\Lg_Village_1.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
			Iterator<Row> itr = sheet.iterator(); // iterating over excel file
			int records = 1;

			itr.next();// skipping header row

			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
//				int i= 1;

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					Object cellValue;
					switch (cell.getColumnIndex()) {
					case 0:
						// StateCode
						cellValue = findCellValue(cell);
						stateCode = ((Integer) (cellValue != null ? cellValue : -11));
						break;
					case 1: // stateName
						break;
					case 2: // census_2011_code
						break;
					case 3:
						// DistCode
						cellValue = findCellValue(cell);
						DistrictCode = ((Integer) (cellValue != null ? cellValue : -11)).longValue();
						break;
					case 4:// DistrictName
						break;
					case 5:// census_2011_code1
						break;
					case 6:
						// SubdistCode
						cellValue = findCellValue(cell);
						subDistCode = (int) (cellValue != null ? cellValue : -11);
						break;
					case 7:// sunDistrictName
						break;
					case 8:// census_2011_code2
						break;
					case 9:// RevenueVillagecode SAME AS ID
						cellValue = findCellValue(cell);
						villageCode = (int) (cellValue != null ? cellValue : -11);
						break;
					case 10:// RevenueVillageName
						cellValue = findCellValueVillageName(cell);
						villageName = (String) (cellValue != null ? cellValue : "");
						break;
					case 11:// census_2011_code3
						break;
					case 12:// blockCode
						cellValue = findCellValue(cell);
						blockCode = (int) (cellValue != null ? cellValue : -11);
						break;
					case 13:// BlockName
						break;
					case 14:// ID
						break;
					case 15:
						// Village_Code_Lg
						cellValue = findCellValue(cell);
						villageCodeLg = (int) (cellValue != null ? cellValue : -11);
						break;
					case 16:// PanchayatCode
						cellValue = findCellValue(cell);
						panchayatCode = (int) (cellValue!=null?cellValue:-11);
						break;
					case 17:// PanchayatName
						cellValue = findCellValueVillageName(cell);
						panchayatName = (String)(cellValue!=null?cellValue:"");
						break;
					default:
//						System.out.println("Error");
						break;
					}

				}

				System.out.println("====================================================================");
				System.out.print((records) + "\t" + stateCode + "\t" + DistrictCode + "\t" + subDistCode);
				System.out.println("\t" + villageName + "\t" + blockCode + "\t" + villageCodeLg
				+ "\t"+ panchayatCode + "\t" + panchayatName);

				if ((records++) == 1) {
//					for first time
					stateMaster = stateMasterRepository.findByStateCode(stateCode);
					districtMaster = districtMasterRepository.findByDistrictCode(DistrictCode);
					subDistrictMaster = subDistrictMasterRepository.getBySubDistrictCode(subDistCode);
					blockMaster = blockMasterRepository.findByBlockCode(blockCode);
				}

				if (!(stateCode == stateMaster.getStateCode())) {
					stateMaster = stateMasterRepository.findByStateCode(stateCode);
				}
				if (!(DistrictCode == districtMaster.getDistrictCode())) {
					districtMaster = districtMasterRepository.findByDistrictCode(DistrictCode);
				}
				if (!(subDistCode == subDistrictMaster.getSubDistrictCode())) {
					subDistrictMaster = subDistrictMasterRepository.getBySubDistrictCode(subDistCode);
				}
				if (!(blockCode == blockMaster.getBlockCode())) {
					blockMaster = blockMasterRepository.findByBlockCode(blockCode);
					if ((blockCode==-11)||(blockMaster == null))
						blockMaster = blockMasterRepository.findByBlockCode(-11);
				}

//				public VillageMaster(Long id, String villageName, Integer villageCode, Integer villageCodeLg,
//				StateMaster stateMaster, DistrictMaster districtMaster, SubDistrictMaster subDistrictMaster,
//				BlockMaster blockMaster, String panchayatName, Integer panchayatCode, boolean active)

				VillageMaster villageMasterConstructor =new  VillageMaster(villageCode.longValue(), villageName, villageCode, villageCodeLg,
						stateMaster, districtMaster, subDistrictMaster, blockMaster, panchayatName, panchayatCode,  true);
				
//				VillageMaster villageMasterConstructor = new VillageMaster(villageCode.longValue(), villageName,
//						villageCode, villageCodeLg, stateMaster, districtMaster, subDistrictMaster, blockMaster,panchayatName,panchayatCode, true);
				villageMasterRepository.save(villageMasterConstructor);
				System.out.println(villageMasterConstructor);
				System.out.println("====================================================================");

//				for handling null
				if (subDistrictMaster == null)
					subDistrictMaster = new SubDistrictMaster(-11, 1, "NA", districtMaster, 1, 1, "NA", -11, false);
//				if (blockMaster == null)
//					blockMaster = new BlockMaster(-11, "NA", districtMaster, subDistrictMaster, false, panchayatCode,
//							villageName);
			}
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
