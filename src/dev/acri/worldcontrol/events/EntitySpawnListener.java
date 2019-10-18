package dev.acri.worldcontrol.events;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dev.acri.worldcontrol.utils.StorageManager;

public class EntitySpawnListener implements Listener{
	
	Random rand = new Random();
	
	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent e) {
		if(StorageManager.getFromWorld(e.getEntity().getWorld()).isExtremeDifficultyEnabled())
			if(e.getEntity() instanceof Monster) {
				Entity en = e.getEntity();
				if(en.getType() == EntityType.ZOMBIE) {
					en = randomSword(en);
					en = randomArmor(en);
				}else if(en.getType() == EntityType.SKELETON) {
					en = randomArmor(en);
					en = randomBow(en);
				}
				
				en = randomEffects(en);
			}
		
		
	}
	
	private Entity randomSword(Entity e) {
		
		Material mat = Material.STONE_SWORD;
		
		int r = rand.nextInt(10);
		if(r > 8) mat = Material.DIAMOND_SWORD;
		else if(r > 3) mat = Material.IRON_SWORD;
		else mat = Material.AIR;
		
		ItemStack item = new ItemStack(mat);
		r = rand.nextInt(8) + 1;
		
		if(r < 6 && mat != Material.AIR)
			item.addEnchantment(Enchantment.DAMAGE_ALL, r);
		
		
		LivingEntity le = (LivingEntity) e;
		le.getEquipment().setItemInMainHand(item);
		
		return le;
	}
	
	private Entity randomBow(Entity e) {
		
		ItemStack item = new ItemStack(Material.BOW);
		
		int r = rand.nextInt(8) + 1;
		if(r < 6)
			item.addEnchantment(Enchantment.ARROW_DAMAGE, r);
		
		r = rand.nextInt(6) + 1;
		if(r < 3)
			item.addEnchantment(Enchantment.ARROW_KNOCKBACK, r);
		
		
		LivingEntity le = (LivingEntity) e;
		le.getEquipment().setItemInMainHand(item);
		
		return le;
	}
	
	private Entity randomArmor(Entity e) {
		LivingEntity le = (LivingEntity) e;
		
		Material mat = Material.AIR;
		
		int r = rand.nextInt(12);
		if(r < 2) mat = Material.LEATHER_BOOTS;
		else if(r < 4) mat = Material.IRON_BOOTS;
		else if(r < 5) mat = Material.DIAMOND_BOOTS;
		
		if(mat != Material.AIR) le.getEquipment().setBoots(randomArmorEnchantment(mat));
		
		mat = Material.AIR;
		r = rand.nextInt(12);
		if(r < 2) mat = Material.LEATHER_LEGGINGS;
		else if(r < 4) mat = Material.IRON_LEGGINGS;
		else if(r < 5) mat = Material.DIAMOND_LEGGINGS;

		if(mat != Material.AIR) le.getEquipment().setLeggings(randomArmorEnchantment(mat));
		
		mat = Material.AIR;
		r = rand.nextInt(12);
		if(r < 2) mat = Material.LEATHER_CHESTPLATE;
		else if(r < 4) mat = Material.IRON_CHESTPLATE;
		else if(r < 5) mat = Material.DIAMOND_CHESTPLATE;

		if(mat != Material.AIR) le.getEquipment().setChestplate(randomArmorEnchantment(mat));
		
		mat = Material.AIR;
		r = rand.nextInt(12);
		if(r < 2) mat = Material.LEATHER_HELMET;
		else if(r < 4) mat = Material.IRON_HELMET;
		else if(r < 5) mat = Material.DIAMOND_HELMET;

		if(mat != Material.AIR) le.getEquipment().setHelmet(randomArmorEnchantment(mat));
		
		return le;
	}
	
	private ItemStack randomArmorEnchantment(Material mat) {
		ItemStack item = new ItemStack(mat);
		
		int r = rand.nextInt(8) + 1;
		if(r < 5)
			item.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, r);
		
		r = rand.nextInt(5) + 1;
		if(r < 4)
			item.addEnchantment(Enchantment.THORNS, r);
		
		return item;
	}
	
	private Entity randomEffects(Entity e) {
		LivingEntity le = (LivingEntity) e;
		
		int r = rand.nextInt(5);
		if(r == 0) le.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100000, 1));
		
		r = rand.nextInt(8);
		if(r == 0) le.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100000, 2));
		
		r = rand.nextInt(15);
		if(r == 0) le.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100000, 3));
		
		r = rand.nextInt(10);
		if(r == 0) le.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100000, 1));
		
		r = rand.nextInt(20);
		if(r == 0) le.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 10));
		
		r = rand.nextInt(8);
		if(r == 0) le.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 2));
		
		r = rand.nextInt(15);
		if(r == 0) le.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 5));
		
		r = rand.nextInt(50);
		if(r == 0) le.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000, 1));
		
		
		
		return le;
	}

}
