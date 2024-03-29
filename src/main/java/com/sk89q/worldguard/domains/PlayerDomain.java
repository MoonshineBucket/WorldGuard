// $Id$
/*
 * WorldGuard
 * Copyright (C) 2010 sk89q <http://www.sk89q.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.sk89q.worldguard.domains;

import java.util.HashSet;
import java.util.Set;

import com.sk89q.worldguard.LocalPlayer;

public class PlayerDomain implements Domain {
    private Set<String> players;

    public PlayerDomain() {
        this.players = new HashSet<String>();
    }

    public PlayerDomain(String[] players) {
        this.players = new HashSet<String>();

        for (String name : players) {
            this.players.add(name.toLowerCase());
        }
    }

    public void addPlayer(String name) {
        players.add(name.toLowerCase());
    }

    public boolean contains(LocalPlayer player) {
        return contains(player.getName());
    }

    @Override
    public boolean contains(String playerName) {
        return players.contains(playerName.toLowerCase());
    }

    public int size() {
        return players.size();
    }
}
