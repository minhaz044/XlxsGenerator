package io.naztech.ExcelGenerator.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sms {
private int id;
private String customerName;
private String address;
private List<ProductOrder> productorderList;
}
