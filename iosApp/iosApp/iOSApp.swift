import SwiftUI
import SharedSDK

@main
struct iOSApp: App {
    
    init() {
        PlatformSdk().doInit(configuration: PlatformConfiguration())
    }
    
    var body: some Scene {
        WindowGroup {
            ZStack {
                Color.init(hex: 0xFF050818)
                    .ignoresSafeArea()
                MainComposeView() //start application for compose screens
            }
//            ContentView() //start application for native screens
        }
    }
}

//import UIKit
//import SharedSDK
//
//@UIApplicationMain
//class AppDelegate: UIResponder, UIApplicationDelegate {
//    var window: UIWindow?
//    
//    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
//        window = UIWindow(frame: UIScreen.main.bounds)
//        let mainViewController = Main_iosKt.MainViewController()
//        window?.rootViewController = mainViewController
//        window?.makeKeyAndVisible()
//        return true
//    }
//}
