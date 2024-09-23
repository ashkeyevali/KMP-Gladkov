//
//  Test+SwiftUI.swift
//  iosApp
//
//  Created by DH-00052469-M on 22.09.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct TestComposeView: UIViewControllerRepresentable {
    
    var onClick: () -> () = {print("TEST")}
    func makeUIViewController(context: Context) -> some UIViewController {
        Test_iosKt.TestViewController {
            onClick()
        }
    }
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
    }
}

