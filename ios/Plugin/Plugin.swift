import Foundation
import Capacitor
import Contacts
/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(DouzeNativeStorage)
public class DouzeNativeStorage: CAPPlugin {
    
    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.success([
            "value": value
        ])
    }
    
    @objc func getContacts(_ call: CAPPluginCall) {
        let defaults = UserDefaults(suiteName: "group.com.qb.quotesboxapp.onesignal")
        let openWith = defaults?.string(forKey: "openWith") ?? ""
        let quote = defaults?.string(forKey: "\(openWith)_quote")
        let id = defaults?.string(forKey: "\(openWith)_id")
        let author = defaults?.string(forKey: "\(openWith)_author")
        let widgetType = defaults?.string(forKey: "\(openWith)_widgetType")
        var contacts = [Any]()
        contacts.append([
            "quote": quote,
            "id": id,
            "author": author,
            "widget": widgetType,
            "openWith": openWith,
            "language": "1",
            "liked": nil,
            "category_id": "15"
            
        ])
        call.success([
            "results": contacts
        ])
    }
}
