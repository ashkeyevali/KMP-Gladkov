//
//  Main_SwiftUi.swift
//  iosApp
//
//  Created by DH-00052469-M on 19.09.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct MainComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> some UIViewController {
        Main_iosKt.MainViewController()
    }
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
    }
}
