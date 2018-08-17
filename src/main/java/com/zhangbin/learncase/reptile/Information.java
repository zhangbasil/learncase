package com.zhangbin.learncase.reptile;

import com.zhangbin.learncase.excel.annotation.DataStyle;
import com.zhangbin.learncase.excel.annotation.Excel;
import com.zhangbin.learncase.excel.annotation.ExcelField;
import com.zhangbin.learncase.excel.annotation.ExcelRowCell;
import com.zhangbin.learncase.excel.annotation.ExportCellStyle;
import com.zhangbin.learncase.excel.annotation.ExportFontStyle;
import com.zhangbin.learncase.excel.annotation.ExportStyle;
import com.zhangbin.learncase.excel.annotation.HeadStyle;
import com.zhangbin.learncase.excel.annotation.StaticExcelRow;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

/**
 * @author zhangbin
 * @Type Information
 * @Desc
 * @date 2018-08-04
 * @Version V1.0
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString

@StaticExcelRow(cells = { @ExcelRowCell(startRow = 0, autoCol = true, value = "${title}") })
 @ExportStyle(
 headStyle=@ExportCellStyle(alignment=CellStyle.ALIGN_CENTER,verticalAlignment=CellStyle.VERTICAL_CENTER,fontStyle=@ExportFontStyle(color=HSSFColor.DARK_BLUE.index)))
@HeadStyle(@ExportCellStyle(alignment = CellStyle.ALIGN_CENTER, verticalAlignment = CellStyle.VERTICAL_CENTER, fontStyle = @ExportFontStyle(color = HSSFColor.DARK_BLUE.index, boldweight = Font.BOLDWEIGHT_BOLD)))
@DataStyle
@Excel(headRow = 1, dataRow = 2)
public class Information {

    @ExcelField(headName = "省份", width = 30)
    String provinceName;

    @ExcelField(headName = "学科", width = 30)
    String course;

    @ExcelField(headName = "排名", width = 20)
    String order;

    @ExcelField(headName = "医院名称", width = 50)
    String hospitalName;

}
