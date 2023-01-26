import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://feri.um.si/')

WebUI.click(findTestObject('Object Repository/Page_FERI/a_KONTAKTI'))

Map seznam = new HashMap()

seznam.put('Brezočnik Lucija', '+386 (2) 22 07 385')

seznam.put('Beranič Tina', '+386 (2) 22 07 354')

seznam.put('Pavlič Luka', '+386 (2) 22 07 356')

for (Map.Entry s : seznam.entrySet()) {
    WebUI.setText(findTestObject('Object Repository/Page_FERI - Kontakti/input'), s.getKey())

    String tel = WebUI.getText(findTestObject('Object Repository/Page_FERI - Kontakti/telefon_field'))
	
	WebUI.verifyMatch(tel, s.getValue(), false)

}

WebUI.closeBrowser()