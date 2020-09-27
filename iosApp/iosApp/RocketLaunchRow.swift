//
//  RocketLaunchRow.swift
//  iosApp
//
//  Created by Shinya Kumagai on 2020/09/27.
//  Copyright © 2020 orgName. All rights reserved.
//

import shared
import SwiftUI

struct RocketLaunchRow: View {
    var rocketLaunch: RocketLaunch
    
    var body: some View {
        HStack() {
            VStack(alignment: .leading, spacing: 10.0) {
                Text("Launch name: \(rocketLaunch.missionName)")
                Text(launchText).foregroundColor(launchColor)
                Text("Launch year: \(rocketLaunch.launchYear)")
                Text("Launch details: \(rocketLaunch.details ?? "")")
            }
            Spacer()
        }
    }
}

private extension RocketLaunchRow {
    var launchText: String {
        if let isSuccess = rocketLaunch.launchSuccess {
            return isSuccess.boolValue ? "Successful" : "Unsuccessful"
        } else {
            return "No data"
        }
    }
    
    var launchColor: Color {
        if let isSuccess = rocketLaunch.launchSuccess {
            return isSuccess.boolValue ? .green : .red
        } else {
            return .gray
        }
    }
}

//struct RocketLaunchRow_Previews: PreviewProvider {
//    static var previews: some View {
//        RocketLaunchRow()
//    }
//}
