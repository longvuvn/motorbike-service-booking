INSERT INTO roles (id, name) VALUES
                                 ('550e8400-e29b-41d4-a716-446655440001', 'ADMIN'),
                                 ('550e8400-e29b-41d4-a716-446655440002', 'CUSTOMER');


INSERT INTO "category_products"
(id, category_name, status, created_at, updated_at, deleted_at)
VALUES
    (gen_random_uuid(), 'Dầu nhớt xe máy', 'ACTIVE', now(), now(), null),
    (gen_random_uuid(), 'Phụ tùng thay thế', 'ACTIVE', now(), now(), null),
    (gen_random_uuid(), 'Phụ kiện xe máy', 'ACTIVE', now(), now(), null),
    (gen_random_uuid(), 'Lốp và ruột xe', 'ACTIVE', now(), now(), null),
    (gen_random_uuid(), 'Ắc quy xe máy', 'ACTIVE', now(), now(), null),
    (gen_random_uuid(), 'Dung dịch chăm sóc xe', 'ACTIVE', now(), now(), null),
    (gen_random_uuid(), 'Thiết bị bảo hộ', 'ACTIVE', now(), now(), null);



INSERT INTO "category_services" (id, category_name, status, created_at, updated_at, deleted_at)
VALUES
    (gen_random_uuid(), 'Bảo dưỡng định kỳ', 'ACTIVE',now(), now(), null),
    (gen_random_uuid(), 'Sửa chữa xe máy', 'ACTIVE', now(), now(), null),
    (gen_random_uuid(), 'Thay dầu nhớt', 'ACTIVE', now(), now(), null),
    (gen_random_uuid(), 'Rửa xe và chăm sóc', 'ACTIVE', now(), now(), null),
    (gen_random_uuid(), 'Kiểm tra và chẩn đoán', 'ACTIVE', now(), now(), null),
    (gen_random_uuid(), 'Cứu hộ xe máy', 'ACTIVE', now(), now(), null),
    (gen_random_uuid(), 'Độ và nâng cấp xe', 'ACTIVE', now(), now(), null);
